package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
@Transactional(readOnly = true)
class EmailController {
    def emailService
    def contactId

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Email.list(params), model:[emailInstanceCount: Email.count()]
    }

    def show(Email emailInstance) {
        respond emailInstance
    }

    def create() {
        contactId = params.contactId
        respond new Email(params)
    }

    @Transactional
    def save(Email emailInstance) {
        log.info "contactId: ${contactId}"
        if (emailInstance == null) {
            notFound()
            return
        }

        if (emailInstance.hasErrors()) {
            respond emailInstance.errors, view:'create'
            return
        }

        emailInstance.save flush:true
        def contact = Contact.findById(contactId)

        try{
          emailService.save(emailInstance, contact)
          request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'email.label', default: 'Email'), emailInstance.id])
                redirect emailInstance
            }
            '*' { respond emailInstance, [status: CREATED] }
          }
        } catch (BusinessException be){
          log.info "${be.message}"
          respond emailInstance
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
