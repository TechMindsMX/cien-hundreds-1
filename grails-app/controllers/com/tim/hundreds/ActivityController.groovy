package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
class ActivityController {
    def activityService

    static hideMe = true /*Parametro para que NO aparezca en el menú*/

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Activity.list(params), model:[activityInstanceCount: Activity.count()]
    }

    def show(Activity activityInstance) {
        respond activityInstance
    }

    def create() {
        respond new Activity(params)
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

        try{
          def instance = activityService.save(activityInstance)
          request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'activity.label', default: 'Activity'), instance.id])
                redirect instance
            }
            '*' { respond instance, [status: CREATED] }
          }
        }catch(Exception ex){
          log.info "${ex.errors}"
          respond activityInstance.musician.errors, view:'create'
        }
    }

    def edit(Activity activityInstance) {
        respond activityInstance
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

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Activity.label', default: 'Activity'), activityInstance.id])
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
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Activity.label', default: 'Activity'), activityInstance.id])
                redirect action:"index", method:"GET"
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
