package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
@Transactional(readOnly = true)
class UserEmailController {

    static hideMe = true /*Parametro para que NO aparezca en el menú*/

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UserEmail.list(params), model:[userEmailInstanceCount: UserEmail.count()]
    }

    def show(UserEmail userEmailInstance) {
        respond userEmailInstance
    }

    def create() {
        respond new UserEmail(params)
    }

    @Transactional
    def save(UserEmail userEmailInstance) {
        if (userEmailInstance == null) {
            notFound()
            return
        }

        if (userEmailInstance.hasErrors()) {
            respond userEmailInstance.errors, view:'create'
            return
        }

        userEmailInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userEmail.label', default: 'UserEmail'), userEmailInstance.id])
                redirect userEmailInstance
            }
            '*' { respond userEmailInstance, [status: CREATED] }
        }
    }

    def edit(UserEmail userEmailInstance) {
        respond userEmailInstance
    }

    @Transactional
    def update(UserEmail userEmailInstance) {
        if (userEmailInstance == null) {
            notFound()
            return
        }

        if (userEmailInstance.hasErrors()) {
            respond userEmailInstance.errors, view:'edit'
            return
        }

        userEmailInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UserEmail.label', default: 'UserEmail'), userEmailInstance.id])
                redirect userEmailInstance
            }
            '*'{ respond userEmailInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(UserEmail userEmailInstance) {

        if (userEmailInstance == null) {
            notFound()
            return
        }

        userEmailInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'UserEmail.label', default: 'UserEmail'), userEmailInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userEmail.label', default: 'UserEmail'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
