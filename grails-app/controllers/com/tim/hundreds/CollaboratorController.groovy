package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
class CollaboratorController {
    def collaboratorService

    static hideMe = true /*Parametro para que NO aparezca en el menú*/

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Collaborator.list(params), model:[collaboratorInstanceCount: Collaborator.count()]
    }

    def show(Collaborator collaboratorInstance) {
        respond collaboratorInstance
    }

    def create() {
        respond new Collaborator(params)
    }

    def save(Collaborator collaboratorInstance) {
        log.info "collaboratorInstance: ${collaboratorInstance.dump()}"
        if (collaboratorInstance == null) {
            notFound()
            return
        }

        if (collaboratorInstance.hasErrors()) {
            respond collaboratorInstance.errors, view:'create'
            return
        }

        try{
          def instance = collaboratorService.save(collaboratorInstance)
          request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'collaborator.label', default: 'Collaborator'), instance.id])
                redirect instance
            }
            '*' { respond instance, [status: CREATED] }
          }
        }catch(Exception ex){
          log.info "Errors: ${ex.message}"
          respond collaboratorInstance.company.errors, view:'create'
        }
    }

    def edit(Collaborator collaboratorInstance) {
        respond collaboratorInstance
    }

    @Transactional
    def update(Collaborator collaboratorInstance) {
        if (collaboratorInstance == null) {
            notFound()
            return
        }

        if (collaboratorInstance.hasErrors()) {
            respond collaboratorInstance.errors, view:'edit'
            return
        }

        collaboratorInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Collaborator.label', default: 'Collaborator'), collaboratorInstance.id])
                redirect collaboratorInstance
            }
            '*'{ respond collaboratorInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Collaborator collaboratorInstance) {

        if (collaboratorInstance == null) {
            notFound()
            return
        }

        collaboratorInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Collaborator.label', default: 'Collaborator'), collaboratorInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'collaborator.label', default: 'Collaborator'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
