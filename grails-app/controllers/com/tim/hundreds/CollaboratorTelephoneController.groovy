package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
@Transactional(readOnly = true)
class CollaboratorTelephoneController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CollaboratorTelephone.list(params), model:[collaboratorTelephoneInstanceCount: CollaboratorTelephone.count()]
    }

    def show(CollaboratorTelephone collaboratorTelephoneInstance) {
        respond collaboratorTelephoneInstance
    }

    def create() {
        respond new CollaboratorTelephone(params)
    }

    @Transactional
    def save(CollaboratorTelephone collaboratorTelephoneInstance) {
        if (collaboratorTelephoneInstance == null) {
            notFound()
            return
        }

        if (collaboratorTelephoneInstance.hasErrors()) {
            respond collaboratorTelephoneInstance.errors, view:'create'
            return
        }

        collaboratorTelephoneInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'collaboratorTelephone.label', default: 'CollaboratorTelephone'), collaboratorTelephoneInstance.id])
                redirect collaboratorTelephoneInstance
            }
            '*' { respond collaboratorTelephoneInstance, [status: CREATED] }
        }
    }

    def edit(CollaboratorTelephone collaboratorTelephoneInstance) {
        respond collaboratorTelephoneInstance
    }

    @Transactional
    def update(CollaboratorTelephone collaboratorTelephoneInstance) {
        if (collaboratorTelephoneInstance == null) {
            notFound()
            return
        }

        if (collaboratorTelephoneInstance.hasErrors()) {
            respond collaboratorTelephoneInstance.errors, view:'edit'
            return
        }

        collaboratorTelephoneInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CollaboratorTelephone.label', default: 'CollaboratorTelephone'), collaboratorTelephoneInstance.id])
                redirect collaboratorTelephoneInstance
            }
            '*'{ respond collaboratorTelephoneInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CollaboratorTelephone collaboratorTelephoneInstance) {

        if (collaboratorTelephoneInstance == null) {
            notFound()
            return
        }

        collaboratorTelephoneInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CollaboratorTelephone.label', default: 'CollaboratorTelephone'), collaboratorTelephoneInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'collaboratorTelephone.label', default: 'CollaboratorTelephone'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
