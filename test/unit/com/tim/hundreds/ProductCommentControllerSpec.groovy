package com.tim.hundreds



import grails.test.mixin.*
import spock.lang.*

@TestFor(ProductCommentController)
@Mock(ProductComment)
class ProductCommentControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.productCommentInstanceList
            model.productCommentInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.productCommentInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def productComment = new ProductComment()
            productComment.validate()
            controller.save(productComment)

        then:"The create view is rendered again with the correct model"
            model.productCommentInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            productComment = new ProductComment(params)

            controller.save(productComment)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/productComment/show/1'
            controller.flash.message != null
            ProductComment.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def productComment = new ProductComment(params)
            controller.show(productComment)

        then:"A model is populated containing the domain instance"
            model.productCommentInstance == productComment
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def productComment = new ProductComment(params)
            controller.edit(productComment)

        then:"A model is populated containing the domain instance"
            model.productCommentInstance == productComment
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/productComment/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def productComment = new ProductComment()
            productComment.validate()
            controller.update(productComment)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.productCommentInstance == productComment

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            productComment = new ProductComment(params).save(flush: true)
            controller.update(productComment)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/productComment/show/$productComment.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/productComment/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def productComment = new ProductComment(params).save(flush: true)

        then:"It exists"
            ProductComment.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(productComment)

        then:"The instance is deleted"
            ProductComment.count() == 0
            response.redirectedUrl == '/productComment/index'
            flash.message != null
    }
}
