package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

@Secured(['ROLE_USER'])
class CollaboratorController {
    def collaboratorService
    def messengineService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Collaborator.list(params), model:[collaboratorInstanceCount: Collaborator.count()]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_BUYER','ROLE_COMPANY_ADMIN','ROLE_COMPANY_VIEWER'])
    def show(Collaborator collaboratorInstance) {
        respond collaboratorInstance
    }

    def create() {
        respond new Collaborator(params)
    }

    @Transactional
    def save(Collaborator collaboratorInstance) {
        if (collaboratorInstance == null) {
            notFound()
            return
        }

        if (collaboratorInstance.hasErrors()) {
            respond collaboratorInstance.errors, view:'create'
            return
        }

        collaboratorInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'collaborator.label', default: 'Collaborator'), collaboratorInstance.id])
                redirect collaboratorInstance
            }
            '*' { respond collaboratorInstance, [status: CREATED] }
        }
    }

    def edit(Collaborator collaboratorInstance) {
        respond collaboratorInstance
    }

    @Transactional
    def update(Collaborator collaboratorInstance) {
        if (collaboratorInstance == null) {
            notFound()
            return
        }

        if (collaboratorInstance.hasErrors()) {
            respond collaboratorInstance.errors, view:'edit'
            return
        }

        collaboratorInstance.save flush:true
        messengineService.sendInstanceEditedMessage(collaboratorInstance.company, 'company')

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Collaborator.label', default: 'Collaborator'), collaboratorInstance.id])
                redirect collaboratorInstance
            }
            '*'{ respond collaboratorInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Collaborator collaboratorInstance) {

        if (collaboratorInstance == null) {
            notFound()
            return
        }

        collaboratorInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Collaborator.label', default: 'Collaborator'), collaboratorInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'collaborator.label', default: 'Collaborator'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def prepareEmail(){
      def collaborator = Collaborator.findByUuid(params.collaboratorUuid)
      render (view: "prepareEmail", model: [collaboratorInstance: collaborator, emailInstance: new Email()])
    }

    def saveEmail(String collaboratorUuid, Email emailInstance){
      def collaborator = Collaborator.findByUuid(collaboratorUuid)
      try{
        collaboratorService.saveEmail(collaborator, emailInstance)
      } catch (ValidationException ve){
        flash.error = g.message(code: 'error.email.limit')
      }
      redirect(uri: "/collaborator/show/${collaborator.id}")
    }

    def prepareTelephone(){
      def collaborator = Collaborator.findByUuid(params.collaboratorUuid)
      render (view: "prepareTelephone", model: [collaboratorInstance: collaborator,telephoneInstance: new Telephone()])
    }

    def saveTelephone(String collaboratorUuid, Telephone telephoneInstance){
      def collaborator = Collaborator.findByUuid(collaboratorUuid)
      log.info "${collaborator.dump()} -- ${telephoneInstance.dump()}"
      try{
        collaboratorService.saveTelephone(collaborator, telephoneInstance)
      } catch (ValidationException ve){
        flash.error = g.message(code: 'error.telephone.limit')
      }
      redirect(uri: "/collaborator/show/${collaborator.id}")
    }

}
