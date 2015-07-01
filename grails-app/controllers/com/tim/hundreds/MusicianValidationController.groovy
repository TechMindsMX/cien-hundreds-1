package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN','ROLE_MUSICIAN_ADMIN'])
class MusicianValidationController {
    def musicianService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MusicianValidation.list(params), model:[musicianValidationInstanceCount: MusicianValidation.count()]
    }

    def show(MusicianValidation musicianValidationInstance) {
        respond musicianValidationInstance
    }

    def create() {
        respond new MusicianValidation(params)
    }

    @Transactional
    def save(MusicianValidation musicianValidationInstance) {
        if (musicianValidationInstance == null) {
            notFound()
            return
        }

        if (musicianValidationInstance.hasErrors()) {
            respond musicianValidationInstance.errors, view:'create'
            return
        }

        musicianService.assignMusicianToFacilitator(musicianValidationInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'musicianValidation.label', default: 'MusicianValidation'), musicianValidationInstance.id])
                redirect musicianValidationInstance
            }
            '*' { respond musicianValidationInstance, [status: CREATED] }
        }
    }

    def edit(MusicianValidation musicianValidationInstance) {
        respond musicianValidationInstance
    }

    @Transactional
    def update(MusicianValidation musicianValidationInstance) {
        if (musicianValidationInstance == null) {
            notFound()
            return
        }

        if (musicianValidationInstance.hasErrors()) {
            respond musicianValidationInstance.errors, view:'edit'
            return
        }

        musicianValidationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MusicianValidation.label', default: 'MusicianValidation'), musicianValidationInstance.id])
                redirect musicianValidationInstance
            }
            '*'{ respond musicianValidationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MusicianValidation musicianValidationInstance) {

        if (musicianValidationInstance == null) {
            notFound()
            return
        }

        musicianValidationInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MusicianValidation.label', default: 'MusicianValidation'), musicianValidationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'musicianValidation.label', default: 'MusicianValidation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
