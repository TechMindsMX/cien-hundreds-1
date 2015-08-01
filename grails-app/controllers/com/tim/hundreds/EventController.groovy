package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityUtils

@Secured(['ROLE_USER'])
class EventController {
    def eventService
    def messengineService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Event.list(params), model:[eventInstanceCount: Event.count()]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_BUYER','ROLE_COMPANY_ADMIN','ROLE_COMPANY_VIEWER'])
    def show(Event eventInstance) {
        eventInstance = eventInstance ?: Event.findByUuid(params.uuid)
        if (eventInstance == null) {
            notFound()
            return
        }
        if (SpringSecurityUtils.ifAnyGranted('ROLE_ADMIN,ROLE_BUYER,ROLE_COMPANY_ADMIN,ROLE_COMPANY_VIEWER') || springSecurityService.currentUser == eventInstance.company.user) {
            respond eventInstance
        } else {
            flash.error = 'access.denied.label'
            redirect url: '/'
        }
        respond eventInstance
    }

    def create() {
        def eventInstance = new Event(params)
        eventInstance.company = Company.findByUuid(params.companyUuid) 
        respond eventInstance
    }

    def save(Event eventInstance) {
        if (eventInstance == null) {
            notFound()
            return
        }

        eventInstance.company = Company.findByUuid(params.companyUuid)
        eventInstance.validate()

        if (eventInstance.hasErrors()) {
            respond eventInstance.errors, view:'create'
            return
        }

        try{
          def instance = eventService.saveEvent(eventInstance)
          request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'event.label', default: 'Event'), instance.id])
                redirect instance
            }
            '*' { respond instance, [status: CREATED] }
          }
        }catch(Exception ex){
          log.info "Errors: ${ex.message}"
          respond eventInstance.company.errors, view:'create'
        }
    }

    def edit(Event eventInstance) {
        eventInstance = Event.findByUuid(params.uuid)
        eventInstance.company = eventInstance.company ?: Company.findByUuid(params.companyUuid) 
        [eventInstance: eventInstance, companyUuid: eventInstance.company.uuid]
    }

    @Transactional
    def update(Event eventInstance) {
        if (eventInstance == null) {
            notFound()
            return
        }

        if (eventInstance.hasErrors()) {
            respond eventInstance.errors, view:'edit'
            return
        }

        eventInstance.company = eventInstance.company ?: Company.findByUuid(params.companyUuid) 
        eventInstance.save flush:true
        messengineService.sendInstanceEditedMessage(eventInstance.company, 'company')

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Event.label', default: 'Event'), eventInstance.id])
                redirect eventInstance
            }
            '*'{ respond eventInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Event eventInstance) {

        if (eventInstance == null) {
            notFound()
            return
        }

        eventInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Event.label', default: 'Event'), eventInstance.id])
                redirect controller: "company", action:"show", params:[uuid: eventInstance.company.uuid]
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            json { render status: NOT_FOUND }
            '*' {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'event.label', default: 'Event'), params.id])
                redirect action: "index", method: "GET"
            }
        }
    }
}
