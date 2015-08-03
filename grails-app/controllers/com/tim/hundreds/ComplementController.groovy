package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityUtils

@Transactional(readOnly = true)
@Secured(['ROLE_USER'])
class ComplementController {

    def messengineService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Complement.list(params), model:[complementInstanceCount: Complement.count()]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_BUYER','ROLE_COMPANY_ADMIN','ROLE_COMPANY_VIEWER'])
    def show(Complement complementInstance) {
        complementInstance = Complement.findByUuid(params.uuid)
        if (complementInstance == null) {
            notFound()
            return
        }
        respond complementInstance
    }

    def create() {
        def complementInstance = new Complement(params)
        complementInstance.product = Product.findByUuid(params.productUuid) 
        respond complementInstance
    }

    @Transactional
    def save(Complement complementInstance) {
        if (complementInstance == null) {
            notFound()
            return
        }

        complementInstance.product = Product.findByUuid(params.productUuid)
        complementInstance.validate()

        if (complementInstance.hasErrors()) {
            respond complementInstance.errors, view:'create'
            return
        }

        complementInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'complement.label', default: 'Complement'), complementInstance.id])
                redirect action: 'show', params: [uuid: complementInstance.uuid]
            }
            '*' { respond complementInstance, [status: CREATED] }
        }
    }

    def edit(Complement complementInstance) {
        complementInstance = Complement.findByUuid(params.uuid)
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
        messengineService.sendInstanceEditedMessage(complementInstance.product.company, 'company')

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Complement.label', default: 'Complement'), complementInstance.id])
                redirect action: 'show', params: [uuid: complementInstance.uuid]
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
                redirect controller: 'product', action:"show", params: [uuid: complementInstance.product.uuid]
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            json { render status: NOT_FOUND }
            '*' {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'complement.label', default: 'Complement'), params.id])
                redirect action: "index", method: "GET"
            }
        }
    }
}
