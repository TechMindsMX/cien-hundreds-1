package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class VideoController {
    def videoService
    def messengineService

    static showMe = false /*Parametro para aparecer en el menú*/

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
      videoInstance.musician = Musician.findByUuid(params.musicianUuid)
      respond videoInstance
    }

    def save(Video videoInstance) {
        if (videoInstance == null) {
            notFound()
            return
        }

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
          respond videoInstance.musician.errors, view:'create'
        }
    }

    def edit(Video videoInstance) {
      log.info "params: ${params.dump()}"
      videoInstance = Video.findByUuid(params.uuid)
      videoInstance.musician = videoInstance.musician ?: Video.findByUuid(params.musicianUuid)
      [videoInstance: videoInstance, musicianUuid: videoInstance.musician.uuid]
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
        messengineService.sendInstanceEditedMessage(videoInstance.musician, 'musician')

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Video.label', default: 'Video'), videoInstance.id])
                redirect controller: "musician", action:"show", params:[uuid: videoInstance.musician.uuid]
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
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Video.label', default: 'Video'), videoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'video.label', default: 'Video'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
