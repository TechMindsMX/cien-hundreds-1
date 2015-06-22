package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured(['ROLE_USER','ROLE_ADMINISTRATOR'])
class ComplementController {

    static hideMe = true /*Parametro para que NO aparezca en el menú*/

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Complement.list(params), model:[complementInstanceCount: Complement.count()]
    }

    def show(Complement complementInstance) {
        respond complementInstance
    }

    def create() {
        respond new Complement(params)
    }

    @Transactional
    def save(Complement complementInstance) {
        if (complementInstance == null) {
            notFound()
            return
        }

        if (complementInstance.hasErrors()) {
            respond complementInstance.errors, view:'create'
            return
        }

        complementInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'complement.label', default: 'Complement'), complementInstance.id])
                redirect complementInstance
            }
            '*' { respond complementInstance, [status: CREATED] }
        }
    }

    def edit(Complement complementInstance) {
        respond complementInstance
    }

    @Transactional
    def update(Complement complementInstance) {
        if (complementInstance == null) {
            notFound()
            return
        }

        if (complementInstance.hasErrors()) {
            respond complementInstance.errors, view:'edit'
            return
        }

        complementInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Complement.label', default: 'Complement'), complementInstance.id])
                redirect complementInstance
            }
            '*'{ respond complementInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Complement complementInstance) {

        if (complementInstance == null) {
            notFound()
            return
        }

        complementInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Complement.label', default: 'Complement'), complementInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'complement.label', default: 'Complement'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
