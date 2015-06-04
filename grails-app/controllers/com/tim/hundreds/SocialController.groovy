package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
@Transactional(readOnly = true)
class SocialController {
    def socialService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Social.list(params), model:[socialInstanceCount: Social.count()]
    }

    def show(Social socialInstance) {
        respond socialInstance
    }

    def create() {
      [
        contactId : params.contactId,
        musicianId : params.musicianId
      ]
    }

    @Transactional
    def save(Social socialInstance) {
        log.info "socialInstance: ${socialInstance.dump()}"
        log.info "musicianId: ${params.musicianId}"
        log.info "contactId: ${params.contactId}"
        if (socialInstance == null) {
            notFound()
            return
        }

        if (socialInstance.hasErrors()) {
            respond socialInstance.errors, view:'create'
            return
        }

        if(params.musicianId){
          def musician = Musician.findById(params.musicianId)
          socialService.saveSocialToInstance(socialInstance, musician)
        }
        if(params.contactId){
          def contact = Contact.findById(params.contactId)
          socialService.saveSocialToInstance(socialInstance, contact)
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'social.label', default: 'Social'), socialInstance.id])
                redirect socialInstance
            }
            '*' { respond socialInstance, [status: CREATED] }
        }
    }

    def edit(Social socialInstance) {
        respond socialInstance
    }

    @Transactional
    def update(Social socialInstance) {
        if (socialInstance == null) {
            notFound()
            return
        }

        if (socialInstance.hasErrors()) {
            respond socialInstance.errors, view:'edit'
            return
        }

        socialInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Social.label', default: 'Social'), socialInstance.id])
                redirect socialInstance
            }
            '*'{ respond socialInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Social socialInstance) {

        if (socialInstance == null) {
            notFound()
            return
        }

        socialInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Social.label', default: 'Social'), socialInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'social.label', default: 'Social'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
