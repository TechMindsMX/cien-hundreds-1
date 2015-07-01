package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN','ROLE_MUSICIAN_ADMIN'])
class ValidationMessageController {

    static showMe = true
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ValidationMessage.list(params), model:[validationMessageInstanceCount: ValidationMessage.count()]
    }

    def show(ValidationMessage validationMessageInstance) {
        respond validationMessageInstance
    }

    def create() {
        respond new ValidationMessage(params)
    }

    @Transactional
    def save(ValidationMessage validationMessageInstance) {
        if (validationMessageInstance == null) {
            notFound()
            return
        }

        if (validationMessageInstance.hasErrors()) {
            respond validationMessageInstance.errors, view:'create'
            return
        }

        validationMessageInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'validationMessage.label', default: 'ValidationMessage'), validationMessageInstance.id])
                redirect validationMessageInstance
            }
            '*' { respond validationMessageInstance, [status: CREATED] }
        }
    }

    def edit(ValidationMessage validationMessageInstance) {
        respond validationMessageInstance
    }

    @Transactional
    def update(ValidationMessage validationMessageInstance) {
        if (validationMessageInstance == null) {
            notFound()
            return
        }

        if (validationMessageInstance.hasErrors()) {
            respond validationMessageInstance.errors, view:'edit'
            return
        }

        validationMessageInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ValidationMessage.label', default: 'ValidationMessage'), validationMessageInstance.id])
                redirect validationMessageInstance
            }
            '*'{ respond validationMessageInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ValidationMessage validationMessageInstance) {

        if (validationMessageInstance == null) {
            notFound()
            return
        }

        validationMessageInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ValidationMessage.label', default: 'ValidationMessage'), validationMessageInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'validationMessage.label', default: 'ValidationMessage'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
