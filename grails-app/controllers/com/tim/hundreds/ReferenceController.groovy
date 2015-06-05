package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
@Transactional(readOnly = true)
class ReferenceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Reference.list(params), model:[referenceInstanceCount: Reference.count()]
    }

    def show(Reference referenceInstance) {
        respond referenceInstance
    }

    def create() {
        respond new Reference(params)
    }

    @Transactional
    def save(Reference referenceInstance) {
        if (referenceInstance == null) {
            notFound()
            return
        }

        if (referenceInstance.hasErrors()) {
            respond referenceInstance.errors, view:'create'
            return
        }

        referenceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reference.label', default: 'Reference'), referenceInstance.id])
                redirect referenceInstance
            }
            '*' { respond referenceInstance, [status: CREATED] }
        }
    }

    def edit(Reference referenceInstance) {
        respond referenceInstance
    }

    @Transactional
    def update(Reference referenceInstance) {
        if (referenceInstance == null) {
            notFound()
            return
        }

        if (referenceInstance.hasErrors()) {
            respond referenceInstance.errors, view:'edit'
            return
        }

        referenceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Reference.label', default: 'Reference'), referenceInstance.id])
                redirect referenceInstance
            }
            '*'{ respond referenceInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Reference referenceInstance) {

        if (referenceInstance == null) {
            notFound()
            return
        }

        referenceInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Reference.label', default: 'Reference'), referenceInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reference.label', default: 'Reference'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
