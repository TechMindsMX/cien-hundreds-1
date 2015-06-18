package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
@Transactional(readOnly = true)
class UserTelephoneController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UserTelephone.list(params), model:[userTelephoneInstanceCount: UserTelephone.count()]
    }

    def show(UserTelephone userTelephoneInstance) {
        respond userTelephoneInstance
    }

    def create() {
        respond new UserTelephone(params)
    }

    @Transactional
    def save(UserTelephone userTelephoneInstance) {
        if (userTelephoneInstance == null) {
            notFound()
            return
        }

        if (userTelephoneInstance.hasErrors()) {
            respond userTelephoneInstance.errors, view:'create'
            return
        }

        userTelephoneInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userTelephone.label', default: 'UserTelephone'), userTelephoneInstance.id])
                redirect userTelephoneInstance
            }
            '*' { respond userTelephoneInstance, [status: CREATED] }
        }
    }

    def edit(UserTelephone userTelephoneInstance) {
        respond userTelephoneInstance
    }

    @Transactional
    def update(UserTelephone userTelephoneInstance) {
        if (userTelephoneInstance == null) {
            notFound()
            return
        }

        if (userTelephoneInstance.hasErrors()) {
            respond userTelephoneInstance.errors, view:'edit'
            return
        }

        userTelephoneInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UserTelephone.label', default: 'UserTelephone'), userTelephoneInstance.id])
                redirect userTelephoneInstance
            }
            '*'{ respond userTelephoneInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(UserTelephone userTelephoneInstance) {

        if (userTelephoneInstance == null) {
            notFound()
            return
        }

        userTelephoneInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'UserTelephone.label', default: 'UserTelephone'), userTelephoneInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userTelephone.label', default: 'UserTelephone'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
