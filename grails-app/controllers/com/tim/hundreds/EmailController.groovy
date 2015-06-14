package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class EmailController {
    def emailService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Email.list(params), model:[emailInstanceCount: Email.count()]
    }

    def show(Email emailInstance) {
        respond emailInstance
    }

    def create() {
        respond new Email(params)
    }

    def save(Email emailInstance) {
      if (emailInstance == null) {
        notFound()
        return
      }

      if (emailInstance.hasErrors()) {
        respond emailInstance.errors, view:'create'
        return
      }

      try{
        def instance = emailService.save(emailInstance)
        request.withFormat {
          form multipartForm {
            flash.message = message(code: 'default.created.message', args: [message(code: 'email.label', default: 'Email'), instance.id])
            redirect instance
          }
          '*' { respond instance, [status: CREATED] }
        }
      } catch (Exception ve){
        log.info "Errors ${ve.message}"
        respond emailInstance.contact.errors, view:'create'
      }
    }

    def edit(Email emailInstance) {
        respond emailInstance
    }

    @Transactional
    def update(Email emailInstance) {
        if (emailInstance == null) {
            notFound()
            return
        }

        if (emailInstance.hasErrors()) {
            respond emailInstance.errors, view:'edit'
            return
        }

        emailInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Email.label', default: 'Email'), emailInstance.id])
                redirect emailInstance
            }
            '*'{ respond emailInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Email emailInstance) {

        if (emailInstance == null) {
            notFound()
            return
        }

        emailInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Email.label', default: 'Email'), emailInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'email.label', default: 'Email'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
