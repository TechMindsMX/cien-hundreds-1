package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_BUYER'])
@Transactional(readOnly = true)
class ProductCommentController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ProductComment.list(params), model:[productCommentInstanceCount: ProductComment.count()]
    }

    def show(ProductComment productCommentInstance) {
        productCommentInstance = ProductComment.findByUuid(params.uuid)
        respond productCommentInstance
    }

    def create() {
        def productComment = new ProductComment(params)
        productComment.product = Product.findByUuid(params.productUuid)
        respond productComment
    }

    @Transactional
    def save(ProductComment productCommentInstance) {
        if (productCommentInstance == null) {
            notFound()
            return
        }

        if (productCommentInstance.hasErrors()) {
            respond productCommentInstance.errors, view:'create'
            return
        }

        productCommentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'productComment.label', default: 'ProductComment'), productCommentInstance.id])
                redirect action: 'show', params: [uuid: productCommentInstance.uuid]
            }
            '*' { respond productCommentInstance, [status: CREATED] }
        }
    }

    def edit(ProductComment productCommentInstance) {
        productCommentInstance = ProductComment.findByUuid(params.uuid)
        respond productCommentInstance
    }

    @Transactional
    def update(ProductComment productCommentInstance) {
        if (productCommentInstance == null) {
            notFound()
            return
        }

        if (productCommentInstance.hasErrors()) {
            respond productCommentInstance.errors, view:'edit'
            return
        }

        productCommentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ProductComment.label', default: 'ProductComment'), productCommentInstance.id])
                redirect action: 'show', params: [uuid: productCommentInstance.uuid]
            }
            '*'{ respond productCommentInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ProductComment productCommentInstance) {

        if (productCommentInstance == null) {
            notFound()
            return
        }

        productCommentInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ProductComment.label', default: 'ProductComment'), productCommentInstance.id])
                redirect controller: "product", action:"show", params:[uuid: productCommentInstance.product.uuid]
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            json { render status: NOT_FOUND }
            '*' {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'productComment.label', default: 'ProductComment'), params.id])
                redirect action: "index", method: "GET"
            }
        }
    }
}
