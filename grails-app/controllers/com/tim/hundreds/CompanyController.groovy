package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN','ROLE_COMPANY_ADMIN'])
class CompanyController {
    def logoStorerService
    def companyService
    def corporatePressStorerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    static showMe = true /*Parametro para aparecer en el menú*/

    @Secured(['ROLE_ADMIN','ROLE_BUYER','ROLE_COMPANY_ADMIN','ROLE_COMPANY_VIEWER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Company.list(params), model:[companyInstanceCount: Company.count()]
    }

    def show(Company companyInstance) {
        respond companyInstance
    }

    def create() {
        respond new Company(params)
    }

    def save(CompanyCommand command) {
        log.info "${command.dump()}"
        if (command.hasErrors()) {
            Company companyInstance = new Company(params)
            companyInstance.errors = command.errors
            render view:'create', model: [companyInstance:companyInstance]
            return
        }

        Company companyInstance = new Company()
        bindData(companyInstance, command)

        if(!params.logo.empty){
          companyInstance.logo = logoStorerService.storeFile(request.getFile('logo'))
        }
        if(!params.corporatePress.empty){
          companyInstance.corporatePress = corporatePressStorerService.storeFile(request.getFile('corporatePress'))
        }

        companyService.save(companyInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'company.label', default: 'Company'), companyInstance.id])
                redirect companyInstance
            }
            '*' { respond companyInstance, [status: CREATED] }
        }
    }

    def edit(Company companyInstance) {
        respond companyInstance
    }

    @Transactional
    def update(Company companyInstance) {
        log.info "${companyInstance.dump()}"
        if (companyInstance == null) {
            notFound()
            return
        }

        if (companyInstance.hasErrors()) {
            respond companyInstance.errors, view:'edit'
            return
        }

        companyInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Company.label', default: 'Company'), companyInstance.id])
                redirect companyInstance
            }
            '*'{ respond companyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Company companyInstance) {

        if (companyInstance == null) {
            notFound()
            return
        }

        companyInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Company.label', default: 'Company'), companyInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
