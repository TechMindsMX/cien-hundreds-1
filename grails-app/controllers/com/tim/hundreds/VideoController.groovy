package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class VideoController {
    def videoService
    def messengineService
    def modelContextService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Video.list(params), model:[videoInstanceCount: Video.count()]
    }

    def show(Video videoInstance) {
        videoInstance = videoInstance ?: Video.findByUuid(params.uuid)
        respond videoInstance
    }

    def create() {
      def videoInstance = new Video(params)
      videoInstance = modelContextService.setParent(videoInstance, params)
      respond videoInstance
    }

    def save(Video videoInstance) {
        if (videoInstance == null) {
            notFound()
            return
        }

        videoInstance = modelContextService.setParent(videoInstance, params)

        if (videoInstance.hasErrors()) {
            respond videoInstance.errors, view:'create'
            return
        }

        try{
          def instance = videoService.saveVideo(videoInstance)
          request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'video.label', default: 'Video'), instance.uuid])
                redirect action: 'show', params: [uuid: instance.uuid]
            }
            '*' { respond instance, [status: CREATED] }
          }
        } catch (Exception ve){
          log.info "Errors ${ve.errors}"
          respond videoInstance.errors, view:'create'
        }
    }

    def edit(Video videoInstance) {
      videoInstance = Video.findByUuid(params.uuid)
      respond videoInstance
    }

    def update(Video videoInstance) {
        if (videoInstance == null) {
            notFound()
            return
        }

        if (videoInstance.hasErrors()) {
            respond videoInstance.errors, view:'edit'
            return
        }

        videoInstance.save flush:true
        def musician = videoService.resolveMusician(videoInstance)
        messengineService.sendInstanceEditedMessage(musician, 'musician')

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Video.label', default: 'Video'), videoInstance.id])
                redirect action:"show", params:[uuid: videoInstance.uuid]
            }
            '*'{ respond videoInstance, [status: OK] }
        }
    }

    def delete(Video videoInstance) {

        if (videoInstance == null) {
            notFound()
            return
        }

        videoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Video.label', default: 'Video'), videoInstance.uuid])
                modelContextService.getParamsForRedirectOnDelete(videoInstance, request)
                redirect controller: request.controller,action:"show", params: [uuid: request.uuid]
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            json { render status: NOT_FOUND }
            '*' {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'audio.label', default: 'Audio'), params.id])
                redirect url: "/"
            }
        }
    }
}
