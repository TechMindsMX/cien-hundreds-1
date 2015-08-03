package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityUtils

@Secured(['ROLE_USER'])
class ProductController {
    def productService
    def messengineService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Product.list(params), model:[productInstanceCount: Product.count()]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_COMPANY_ADMIN','ROLE_COMPANY_VIEWER','ROLE_BUYER'])
    def show(Product productInstance) {
        productInstance = productInstance ?: Product.findByUuid(params.uuid)
        if (productInstance == null) {
            notFound()
            return
        }
        if (SpringSecurityUtils.ifAnyGranted('ROLE_ADMIN,ROLE_BUYER,ROLE_COMPANY_ADMIN,ROLE_COMPANY_VIEWER') || springSecurityService.currentUser == productInstance.company.user) {
            respond productInstance
        } else {
            flash.error = 'access.denied.label'
            redirect url: '/'
        }
    }

    def create() {
        def productInstance = new Product(params)
        productInstance.company = Company.findByUuid(params.companyUuid) 
        respond productInstance
    }

    def save(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        productInstance.company = Company.findByUuid(params.companyUuid)
        productInstance.validate()

        if (productInstance.hasErrors()) {
            respond productInstance.errors, view:'create'
            return
        }

        try{

          def instance = productService.save(productInstance)
          request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'product.label', default: 'Product'), instance.id])
                redirect productInstance
            }
            '*' { respond instance, [status: CREATED] }
          }
        }catch(Exception ex){
          log.info "Errors: ${ex.message}"
          respond productInstance.company.errors, view:'create'
        }
    }

    def edit(Product productInstance) {
        productInstance = Product.findByUuid(params.uuid)
        productInstance.company = productInstance.company ?: Company.findByUuid(params.companyUuid) 
        [productInstance: productInstance, companyUuid: productInstance.company.uuid]
    }

    @Transactional
    def update(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        if (productInstance.hasErrors()) {
            respond productInstance.errors, view:'edit'
            return
        }

        productInstance.company = productInstance.company ?: Company.findByUuid(params.companyUuid) 
        productInstance.save flush:true
        messengineService.sendInstanceEditedMessage(productInstance.company, 'company')

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect productInstance
            }
            '*'{ respond productInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Product productInstance) {

        if (productInstance == null) {
            notFound()
            return
        }

        productInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect controller: "company", action:"show", params:[uuid: productInstance.company.uuid]
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            json { render status: NOT_FOUND }
            '*' {
                flash.error = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
                redirect action: "index", method: "GET"
            }
        }
    }

}
