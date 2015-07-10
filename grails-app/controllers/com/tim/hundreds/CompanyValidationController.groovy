package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN','ROLE_COMPANY_ADMIN', 'ROLE_BUYER'])
class CompanyValidationController {
    def companyService

    static showMe = true
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETEs"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompanyValidation.list(params), model:[companyValidationInstanceCount: CompanyValidation.count()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_COMPANY_ADMIN','ROLE_BUYER'])
    def show(CompanyValidation companyValidationInstance) {
        respond companyValidationInstance
    }

    def create() {
      def roleBuyer = Role.findByAuthority("ROLE_BUYER")
      def users = UserRole.findAllByRole(roleBuyer)
      respond new CompanyValidation(params), [model:[buyers:users*.user]]
    }

    @Transactional
    def save(CompanyValidation companyValidationInstance) {
        if (companyValidationInstance == null) {
            notFound()
            return
        }

        if (companyValidationInstance.hasErrors()) {
            respond companyValidationInstance.errors, view:'create'
            return
        }

        companyService.assignCompanyToBuyer(companyValidationInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companyValidation.label', default: 'CompanyValidation'), companyValidationInstance.id])
                redirect companyValidationInstance
            }
            '*' { respond companyValidationInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_COMPANY_ADMIN','ROLE_BUYER'])
    def edit(CompanyValidation companyValidationInstance) {
      def roleBuyer = Role.findByAuthority("ROLE_BUYER")
      def users = UserRole.findAllByRole(roleBuyer)
      respond companyValidationInstance, [model:[buyers:users*.user]]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_COMPANY_ADMIN','ROLE_BUYER'])
    @Transactional
    def update(CompanyValidation companyValidationInstance) {
        if (companyValidationInstance == null) {
            notFound()
            return
        }

        if (companyValidationInstance.hasErrors()) {
            respond companyValidationInstance.errors, view:'edit'
            return
        }

        companyValidationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CompanyValidation.label', default: 'CompanyValidation'), companyValidationInstance.id])
                redirect companyValidationInstance
            }
            '*'{ respond companyValidationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CompanyValidation companyValidationInstance) {

        if (companyValidationInstance == null) {
            notFound()
            return
        }

        companyValidationInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompanyValidation.label', default: 'CompanyValidation'), companyValidationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'companyValidation.label', default: 'CompanyValidation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
