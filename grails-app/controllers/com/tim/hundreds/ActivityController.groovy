package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityUtils

@Secured(['ROLE_USER'])
class ActivityController {
    def activityService
    def messengineService
    def springSecurityService

    static showMe = false /*Parametro para aparecer en el menú*/

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Activity.list(params), model:[activityInstanceCount: Activity.count()]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_MUSICIAN_ADMIN','ROLE_MUSICIAN_VIEWER','ROLE_FACILITATOR'])
    def show(Activity activityInstance) {
        activityInstance = activityInstance ?: Activity.findByUuid(params.uuid)
        if(SpringSecurityUtils.ifAnyGranted('ROLE_ADMIN,ROLE_FACILITATOR,ROLE_MUSICIAN_ADMIN,ROLE_MUSICIAN_VIEWER') || springSecurityService.currentUser == activityInstance.musician.user) {
            respond activityInstance
        } else {
            flash.error = 'access.denied.label'
            redirect url: '/'
        }
    }

    def create() {
        def activityInstance = new Activity(params)
        activityInstance = modelContextService.setParent(activityInstance, params)
        respond activityInstance
    }

    def save(Activity activityInstance) {
        if (activityInstance == null) {
            notFound()
            return
        }

        if (activityInstance.hasErrors()) {
            respond activityInstance.errors, view:'create'
            return
        }

        activityInstance = modelContextService.setParent(activityInstance, params)

        try{
          def instance = activityService.saveActivity(activityInstance)
          request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'activity.label', default: 'Activity'), instance.uuid])
                redirect action: 'show', params: [uuid: instance.uuid]
            }
            '*' { respond instance, [status: CREATED] }
          }
        }catch(Exception ex){
          log.info "${ex.errors}"
          respond activityInstance.musician.errors, view:'create'
        }
    }

    def edit(Activity activityInstance) {
      activityInstance = Activity.findByUuid(params.uuid)
      activityInstance.musician = activityInstance.musician ?: Activity.findByUuid(params.musicianUuid)
      [activityInstance: activityInstance, musicianUuid: activityInstance.musician.uuid]
    }

    @Transactional
    def update(Activity activityInstance) {
        if (activityInstance == null) {
            notFound()
            return
        }

        if (activityInstance.hasErrors()) {
            respond activityInstance.errors, view:'edit'
            return
        }

        activityInstance.save flush:true
        def musician = audioService.resolveMusician(audioInstance)
        messengineService.sendInstanceEditedMessage(musician, 'musician')

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Activity.label', default: 'Activity'), activityInstance.uuid])
                redirect activityInstance
            }
            '*'{ respond activityInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Activity activityInstance) {

        if (activityInstance == null) {
            notFound()
            return
        }

        activityInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Activity.label', default: 'Activity'), activityInstance.uuid])
                modelContextService.getParamsForRedirectOnDelete(activityInstance, request)
                redirect controller: "musician", action:"show", params:[uuid: acitvityInstance.musician.uuid]
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'activity.label', default: 'Activity'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
