package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_FACILITATOR'])
@Transactional(readOnly = true)
class MusicianCommentController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MusicianComment.list(params), model:[musicianCommentInstanceCount: MusicianComment.count()]
    }

    @Secured(['ROLE_FACILITATOR','ROLE_MUSICIAN_VIEWER'])
    def show(MusicianComment musicianCommentInstance) {
        respond musicianCommentInstance
    }

    def create() {
        respond new MusicianComment(params)
    }

    @Transactional
    def save(MusicianComment musicianCommentInstance) {
        if (musicianCommentInstance == null) {
            notFound()
            return
        }

        if (musicianCommentInstance.hasErrors()) {
            respond musicianCommentInstance.errors, view:'create'
            return
        }

        musicianCommentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'musicianComment.label', default: 'MusicianComment'), musicianCommentInstance.id])
                redirect musicianCommentInstance
            }
            '*' { respond musicianCommentInstance, [status: CREATED] }
        }
    }

    def edit(MusicianComment musicianCommentInstance) {
        respond musicianCommentInstance
    }

    @Transactional
    def update(MusicianComment musicianCommentInstance) {
        if (musicianCommentInstance == null) {
            notFound()
            return
        }

        if (musicianCommentInstance.hasErrors()) {
            respond musicianCommentInstance.errors, view:'edit'
            return
        }

        musicianCommentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MusicianComment.label', default: 'MusicianComment'), musicianCommentInstance.id])
                redirect musicianCommentInstance
            }
            '*'{ respond musicianCommentInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MusicianComment musicianCommentInstance) {

        if (musicianCommentInstance == null) {
            notFound()
            return
        }

        musicianCommentInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MusicianComment.label', default: 'MusicianComment'), musicianCommentInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'musicianComment.label', default: 'MusicianComment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
