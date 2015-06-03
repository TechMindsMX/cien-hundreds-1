package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
@Transactional(readOnly = true)
class TelephoneController {
    def contactId

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Telephone.list(params), model:[telephoneInstanceCount: Telephone.count()]
    }

    def show(Telephone telephoneInstance) {
        respond telephoneInstance
    }

    def create() {
      contactId = params.contactId
      respond new Telephone(params)
    }

    @Transactional
    def save(Telephone telephoneInstance) {
        log.info "contactId: ${contactId}"
        if (telephoneInstance == null) {
            notFound()
            return
        }

        if (telephoneInstance.hasErrors()) {
            respond telephoneInstance.errors, view:'create'
            return
        }

        telephoneInstance.save flush:true
        def contact = Contact.findById(contactId)
        contact.telephones.add(telephoneInstance)
        contact.save()

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'telephone.label', default: 'Telephone'), telephoneInstance.id])
                redirect telephoneInstance
            }
            '*' { respond telephoneInstance, [status: CREATED] }
        }
    }

    def edit(Telephone telephoneInstance) {
        respond telephoneInstance
    }

    @Transactional
    def update(Telephone telephoneInstance) {
        if (telephoneInstance == null) {
            notFound()
            return
        }

        if (telephoneInstance.hasErrors()) {
            respond telephoneInstance.errors, view:'edit'
            return
        }

        telephoneInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Telephone.label', default: 'Telephone'), telephoneInstance.id])
                redirect telephoneInstance
            }
            '*'{ respond telephoneInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Telephone telephoneInstance) {

        if (telephoneInstance == null) {
            notFound()
            return
        }

        telephoneInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Telephone.label', default: 'Telephone'), telephoneInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'telephone.label', default: 'Telephone'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
