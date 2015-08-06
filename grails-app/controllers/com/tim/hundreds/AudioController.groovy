package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class AudioController {
    def audioService
    def messengineService
    def modelContextService

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
      def audioInstance = new Audio(params)
      audioInstance = modelContextService.setParent(audioInstance, params)
      respond audioInstance
    }

    def save(Audio audioInstance) {
        if (audioInstance == null) {
            notFound()
            return
        }

        audioInstance = modelContextService.setParent(audioInstance, params)

        if (audioInstance.hasErrors()) {
            respond audioInstance.errors, view:'create'
            return
        }

        try{
          def instance = audioService.saveAudio(audioInstance)
          request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'audio.label', default: 'Audio'), instance.id])
                redirect action: 'show', params: [uuid: audioInstance.uuid]
            }
            '*' { respond instance, [status: CREATED] }
          }
        } catch (Exception ve){
          log.info "Errors ${ve.dump()}"
          respond audioInstance.errors, view:'create'
        }
    }

    def edit(Audio audioInstance) {
      audioInstance = Audio.findByUuid(params.uuid)
      respond audioInstance
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
        def musician = audioService.resolveMusician(audioInstance)
        messengineService.sendInstanceEditedMessage(musician, 'musician')

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Audio.label', default: 'Audio'), audioInstance.id])
                redirect action:"show", params:[uuid: audioInstance.uuid]
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
                modelContextService.getParamsForRedirectOnDelete(audioInstance, request)
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
