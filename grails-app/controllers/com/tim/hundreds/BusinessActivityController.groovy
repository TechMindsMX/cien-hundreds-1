package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class BusinessActivityController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond BusinessActivity.list(params), model:[businessActivityInstanceCount: BusinessActivity.count()]
    }

    def show(BusinessActivity businessActivityInstance) {
        respond businessActivityInstance
    }

    def create() {
        respond new BusinessActivity(params)
    }

    @Transactional
    def save(BusinessActivity businessActivityInstance) {
        if (businessActivityInstance == null) {
            notFound()
            return
        }

        if (businessActivityInstance.hasErrors()) {
            respond businessActivityInstance.errors, view:'create'
            return
        }

        businessActivityInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'businessActivity.label', default: 'BusinessActivity'), businessActivityInstance.id])
                redirect businessActivityInstance
            }
            '*' { respond businessActivityInstance, [status: CREATED] }
        }
    }

    def edit(BusinessActivity businessActivityInstance) {
        respond businessActivityInstance
    }

    @Transactional
    def update(BusinessActivity businessActivityInstance) {
        if (businessActivityInstance == null) {
            notFound()
            return
        }

        if (businessActivityInstance.hasErrors()) {
            respond businessActivityInstance.errors, view:'edit'
            return
        }

        businessActivityInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'BusinessActivity.label', default: 'BusinessActivity'), businessActivityInstance.id])
                redirect businessActivityInstance
            }
            '*'{ respond businessActivityInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(BusinessActivity businessActivityInstance) {

        if (businessActivityInstance == null) {
            notFound()
            return
        }

        businessActivityInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'BusinessActivity.label', default: 'BusinessActivity'), businessActivityInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'businessActivity.label', default: 'BusinessActivity'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
