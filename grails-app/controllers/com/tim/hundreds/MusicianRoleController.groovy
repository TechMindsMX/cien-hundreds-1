package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN','ROLE_MUSICIAN_ADMIN'])
@Transactional(readOnly = true)
class MusicianRoleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MusicianRole.list(params), model:[musicianRoleInstanceCount: MusicianRole.count()]
    }

    def show(MusicianRole musicianRoleInstance) {
        respond musicianRoleInstance
    }

    def create() {
        respond new MusicianRole(params)
    }

    @Transactional
    def save(MusicianRole musicianRoleInstance) {
        if (musicianRoleInstance == null) {
            notFound()
            return
        }

        if (musicianRoleInstance.hasErrors()) {
            respond musicianRoleInstance.errors, view:'create'
            return
        }

        musicianRoleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'musicianRole.label', default: 'MusicianRole'), musicianRoleInstance.id])
                redirect musicianRoleInstance
            }
            '*' { respond musicianRoleInstance, [status: CREATED] }
        }
    }

    def edit(MusicianRole musicianRoleInstance) {
        respond musicianRoleInstance
    }

    @Transactional
    def update(MusicianRole musicianRoleInstance) {
        if (musicianRoleInstance == null) {
            notFound()
            return
        }

        if (musicianRoleInstance.hasErrors()) {
            respond musicianRoleInstance.errors, view:'edit'
            return
        }

        musicianRoleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MusicianRole.label', default: 'MusicianRole'), musicianRoleInstance.id])
                redirect musicianRoleInstance
            }
            '*'{ respond musicianRoleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MusicianRole musicianRoleInstance) {

        if (musicianRoleInstance == null) {
            notFound()
            return
        }

        musicianRoleInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MusicianRole.label', default: 'MusicianRole'), musicianRoleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'musicianRole.label', default: 'MusicianRole'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
