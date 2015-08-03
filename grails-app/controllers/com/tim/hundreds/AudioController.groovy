package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class AudioController {
    def audioService
    def messengineService

    static showMe = false /*Parametro para aparecer en el menú*/

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Audio.list(params), model:[audioInstanceCount: Audio.count()]
    }

    def show(Audio audioInstance) {
        audioInstance = audioInstance ?: Audio.findByUuid(params.uuid)
        respond audioInstance
    }

    def create() {
      def audioInstance = new Video(params)
      audioInstance.musician = Musician.findByUuid(params.musicianUuid)
      respond audioInstance

    }

    def save(Audio audioInstance) {
        if (audioInstance == null) {
            notFound()
            return
        }

        if (audioInstance.hasErrors()) {
            respond audioInstance.errors, view:'create'
            return
        }

        try{
          def instance = audioService.saveAudio(audioInstance)
          request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'audio.label', default: 'Audio'), instance.id])
                redirect action: 'show', params: [uuid: instance.uuid]
            }
            '*' { respond instance, [status: CREATED] }
          }
        } catch (Exception ve){
          log.info "Errors ${ve.errors}"
          respond audioInstance.musician.errors, view:'create'
        }
    }

    def edit(Audio audioInstance) {
      audioInstance = Video.findByUuid(params.uuid)
      audioInstance.musician = audioInstance.musician ?: Video.findByUuid(params.musicianUuid)
      [audioInstance: audioInstance, musicianUuid: audioInstance.musician.uuid]
   }

    @Transactional
    def update(Audio audioInstance) {
        if (audioInstance == null) {
            notFound()
            return
        }

        if (audioInstance.hasErrors()) {
            respond audioInstance.errors, view:'edit'
            return
        }

        audioInstance.save flush:true
        messengineService.sendInstanceEditedMessage(audioInstance.musician, 'musician')

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Audio.label', default: 'Audio'), audioInstance.id])
                redirect controller: "musician", action:"show", params:[uuid: audioInstance.musician.uuid]
            }
            '*'{ respond audioInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Audio audioInstance) {

        if (audioInstance == null) {
            notFound()
            return
        }

        audioInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Audio.label', default: 'Audio'), audioInstance.uuid])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'audio.label', default: 'Audio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
