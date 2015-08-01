package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityUtils

@Secured(['ROLE_USER'])
class CompanyController {
    def logoStorerService
    def companyService
    def messengineService
    def corporatePressStorerService
    def tagService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_BUYER','ROLE_COMPANY_ADMIN','ROLE_COMPANY_VIEWER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def companyList = companyService.getCompanyList(springSecurityService.currentUser, params)
        respond companyList.list, model:[companyListCount: companyList.count]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_BUYER','ROLE_COMPANY_ADMIN','ROLE_COMPANY_VIEWER'])
    def show(Company companyInstance) {
        companyInstance = Company.findByUuid(params.uuid)
        if (companyInstance == null) {
            notFound()
            return
        }
        if (SpringSecurityUtils.ifAnyGranted('ROLE_ADMIN,ROLE_BUYER,ROLE_COMPANY_ADMIN,ROLE_COMPANY_VIEWER') || springSecurityService.currentUser == companyInstance.user) {
            respond companyInstance
        } else {
            flash.error = 'access.denied.label'
            redirect url: '/'
        }
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

        if(!params.logo.isEmpty()){
          command.logoPath = logoStorerService.storeFile(request.getFile('logo'))
        }
        if(!params.corporatePress.isEmpty()){
          command.corporatePressPath = corporatePressStorerService.storeFile(request.getFile('corporatePress'))
        }

        Company companyInstance = new Company()
        bindData(companyInstance, command)
        companyService.save(companyInstance)

        tagService.addTags(companyInstance, "${command.name},${command.type.name},${command.tagsComma}")

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'company.label', default: 'Company'), companyInstance.id])
                redirect action: 'show', params: [uuid:companyInstance.uuid]
            }
            '*' { respond companyInstance, [status: CREATED] }
        }
    }

    def edit(Company companyInstance) {
        companyInstance = Company.findByUuid(params.uuid)
        respond companyInstance
    }

    def update(CompanyCommand command) {
        log.info "${command.dump()}"
        if (command.hasErrors()) {
            Company companyInstance = new Company(params)
            companyInstance.errors = command.errors
            render view:'edit', model: [companyInstance:companyInstance]
            return
        }

        if(!params.logo.isEmpty()){
          command.logoPath = logoStorerService.storeFile(request.getFile('logo'))
        }
        if(!params.corporatePress.isEmpty()){
          command.corporatePressPath = corporatePressStorerService.storeFile(request.getFile('corporatePress'))
        }

        def companyInstance = Company.findByUuid(command.uuid)
        DataBinder.copy(companyInstance, command)
        companyService.save(companyInstance)

        tagService.dropTags(companyInstance)
        tagService.addTags(companyInstance, "${command.tagsComma}")
        messengineService.sendInstanceEditedMessage(companyInstance, 'company')

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Company.label', default: 'Company'), companyInstance.id])
                redirect action: 'show', params: [uuid:companyInstance.uuid]
            }
            '*'{ respond companyInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_COMPANY_ADMIN'])
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

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_BUYER','ROLE_COMPANY_ADMIN','ROLE_COMPANY_VIEWER'])
    def creationReportFilter() {
      log.info "Listing companies created from ${params.from} to ${params.to}"
      def companies
      try{
        params.from = params.from ?: '01-01-1900'
        params.to = params.to ?: new Date().format('dd-MM-yyyy').toString()
        Date startDate = Date.parse('dd-MM-yyyy', params.from) 
        Date endDate = Date.parse('dd-MM-yyyy', params.to)
        companies = companyService.getCompaniesByDateCreated(startDate, endDate)
      }catch(InvalidParamsException ipe){
        log.warn ipe.message
        flash.error=g.message(code: 'error.date.range')
      }
      render view:'creationReportView', model: [companyInstanceList: companies]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_BUYER','ROLE_COMPANY_ADMIN','ROLE_COMPANY_VIEWER'])
    def creationReportView() {
    }

    protected void notFound() {
        request.withFormat {
            json { render status: NOT_FOUND }
            '*' {
                flash.error = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), params.id])
                redirect action: "index", method: "GET"
            }
        }
    }
}
