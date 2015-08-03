package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityUtils

@Secured(['ROLE_USER'])
class ReferenceController {
    def referenceService
    def messengineService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Reference.list(params), model:[referenceInstanceCount: Reference.count()]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_BUYER','ROLE_COMPANY_ADMIN','ROLE_COMPANY_VIEWER'])
    def show(Reference referenceInstance) {
        referenceInstance = referenceInstance ?: Reference.findByUuid(params.uuid)
        if (referenceInstance == null) {
            notFound()
            return
        }
        if (SpringSecurityUtils.ifAnyGranted('ROLE_ADMIN,ROLE_BUYER,ROLE_COMPANY_ADMIN,ROLE_COMPANY_VIEWER') || springSecurityService.currentUser == referenceInstance.company.user) {
            respond referenceInstance
        } else {
            flash.error = 'access.denied.label'
            redirect url: '/'
        }
        respond referenceInstance
    }

    def create() {
        def referenceInstance = new Reference(params)
        referenceInstance.company = Company.findByUuid(params.companyUuid) 
        respond referenceInstance
    }

    def save(Reference referenceInstance) {
        if (referenceInstance == null) {
            notFound()
            return
        }

        referenceInstance.company = Company.findByUuid(params.companyUuid)
        referenceInstance.validate()

        if (referenceInstance.hasErrors()) {
            respond referenceInstance.errors, view:'create'
            return
        }

        try{
          def instance = referenceService.saveReference(referenceInstance)
          request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reference.label', default: 'Reference'), instance.id])
                redirect action:"show", params:[uuid: referenceInstance.uuid]
            }
            '*' { respond instance, [status: CREATED] }
          }
        }catch(Exception ex){
          log.info "Errors ${ex.errors}"
          respond referenceInstance.company.errors, view:'create'
        }
    }

    def edit(Reference referenceInstance) {
        referenceInstance = Reference.findByUuid(params.uuid)
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
        messengineService.sendInstanceEditedMessage(referenceInstance.company, 'company')

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Reference.label', default: 'Reference'), referenceInstance.id])
                redirect action:"show", params:[uuid: referenceInstance.uuid]
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
                redirect controller: "company", action:"show", params:[uuid: referenceInstance.company.uuid]
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            json { render status: NOT_FOUND }
            '*' {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reference.label', default: 'Reference'), params.id])
                redirect action: "index", method: "GET"
            }
        }
    }
}
