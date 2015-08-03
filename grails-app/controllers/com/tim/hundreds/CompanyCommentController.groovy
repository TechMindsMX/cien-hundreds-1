package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_BUYER'])
@Transactional(readOnly = true)
class CompanyCommentController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompanyComment.list(params), model:[companyCommentInstanceCount: CompanyComment.count()]
    }

    @Secured(['ROLE_BUYER','ROLE_COMPANY_VIEWER'])
    def show(CompanyComment companyCommentInstance) {
        companyCommentInstance = CompanyComment.findByUuid(params.uuid)
        respond companyCommentInstance
    }

    def create() {
        def companyComment = new CompanyComment(params)
        companyComment.company = Company.findByUuid(params.companyUuid)
        respond companyComment
    }

    @Transactional
    def save(CompanyComment companyCommentInstance) {
        companyCommentInstance = CompanyComment.findByUuid(params.uuid)
        if (companyCommentInstance == null) {
            notFound()
            return
        }

        if (companyCommentInstance.hasErrors()) {
            respond companyCommentInstance.errors, view:'create'
            return
        }

        companyCommentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companyComment.label', default: 'CompanyComment'), companyCommentInstance.id])
                redirect action: 'show', params: [uuid: companyCommentInstance.uuid]
            }
            '*' { respond companyCommentInstance, [status: CREATED] }
        }
    }

    def edit(CompanyComment companyCommentInstance) {
        companyCommentInstance = CompanyComment.findByUuid(params.uuid)
        respond companyCommentInstance
    }

    @Transactional
    def update(CompanyComment companyCommentInstance) {
        if (companyCommentInstance == null) {
            notFound()
            return
        }

        if (companyCommentInstance.hasErrors()) {
            respond companyCommentInstance.errors, view:'edit'
            return
        }

        companyCommentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CompanyComment.label', default: 'CompanyComment'), companyCommentInstance.id])
                redirect action: 'show', params: [uuid: companyCommentInstance.uuid]
            }
            '*'{ respond companyCommentInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CompanyComment companyCommentInstance) {

        if (companyCommentInstance == null) {
            notFound()
            return
        }

        companyCommentInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompanyComment.label', default: 'CompanyComment'), companyCommentInstance.id])
                redirect controller: "company", action:"show", params:[uuid: companyCommentInstance.company.uuid]
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'companyComment.label', default: 'CompanyComment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
