package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
@Transactional(readOnly = true)
class CollaboratorEmailController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CollaboratorEmail.list(params), model:[collaboratorEmailInstanceCount: CollaboratorEmail.count()]
    }

    def show(CollaboratorEmail collaboratorEmailInstance) {
        respond collaboratorEmailInstance
    }

    def create() {
        respond new CollaboratorEmail(params)
    }

    @Transactional
    def save(CollaboratorEmail collaboratorEmailInstance) {
        if (collaboratorEmailInstance == null) {
            notFound()
            return
        }

        if (collaboratorEmailInstance.hasErrors()) {
            respond collaboratorEmailInstance.errors, view:'create'
            return
        }

        collaboratorEmailInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'collaboratorEmail.label', default: 'CollaboratorEmail'), collaboratorEmailInstance.id])
                redirect collaboratorEmailInstance
            }
            '*' { respond collaboratorEmailInstance, [status: CREATED] }
        }
    }

    def edit(CollaboratorEmail collaboratorEmailInstance) {
        respond collaboratorEmailInstance
    }

    @Transactional
    def update(CollaboratorEmail collaboratorEmailInstance) {
        if (collaboratorEmailInstance == null) {
            notFound()
            return
        }

        if (collaboratorEmailInstance.hasErrors()) {
            respond collaboratorEmailInstance.errors, view:'edit'
            return
        }

        collaboratorEmailInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CollaboratorEmail.label', default: 'CollaboratorEmail'), collaboratorEmailInstance.id])
                redirect collaboratorEmailInstance
            }
            '*'{ respond collaboratorEmailInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CollaboratorEmail collaboratorEmailInstance) {

        if (collaboratorEmailInstance == null) {
            notFound()
            return
        }

        collaboratorEmailInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CollaboratorEmail.label', default: 'CollaboratorEmail'), collaboratorEmailInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'collaboratorEmail.label', default: 'CollaboratorEmail'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
