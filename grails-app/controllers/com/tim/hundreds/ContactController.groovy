package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

@Secured(['ROLE_USER'])
class ContactController {
    def photoStorerService
    def contactService
    def messengineService
    def tagService

    static showMe = false /*Parametro para aparecer en el menú*/

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Contact.list(params), model:[contactInstanceCount: Contact.count()]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_FACILITATOR','ROLE_MUSICIAN_ADMIN','ROLE_MUSICIAN_VIEWER'])
    def show(Contact contactInstance) {
        respond contactInstance
    }

    def create() {
      [
        musicianUuid : params.musicianUuid
      ]
    }

    def save(ContactCommand command) {
        if (command == null) {
            notFound()
            return
        }

        if (command.hasErrors()) {
            respond command.errors, view: 'create'
            return
        }

        if(!params.file.isEmpty()){
          command.photoPath = photoStorerService.storeFile(request.getFile('file'))
        }
        Contact contactInstance = new Contact()
        bindData(contactInstance, command)
        Musician musician = Musician.findById(params.musician.id)
        contactInstance.musician = musician
        tagService.addTags(musician, "${contactInstance.firstName},${contactInstance.lastName},${contactInstance.motherLastName}")
        try{
          def instance = contactService.save(contactInstance)
          def telephone = new Telephone(phone:command.phone,phoneType:command.phoneType)
          def email = new Email(mail:command.mail,emailType:command.emailType)
          instance = contactService.saveEmail(instance,email)
          instance = contactService.saveTelephone(instance,telephone)
           request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'contact.label', default: 'Contact'), instance.id])
                redirect instance
            }
            '*' { respond instance, [status: CREATED] }
          }
        }catch(Exception ex){
          log.info "Errors: ${ex}"
          respond contactInstance.musician.errors, view:'create'
        }

    }

    def edit(Contact contactInstance) {
      flash.edit = "true"
      respond contactInstance
    }

    @Transactional
    def update(Contact contactInstance) {
        if (contactInstance == null) {
            notFound()
            return
        }

        if (contactInstance.hasErrors()) {
            respond contactInstance.errors, view:'edit'
            return
        }

        contactInstance.save flush:true
        try {
          messengineService.sendInstanceEditedMessage(contactInstance.musician, 'musician')
        }
        catch(BusinessException ex){
          log.error message(code:'message.service.down', default:"service temporarily down")
        }
        finally {
          request.withFormat {
              form multipartForm {
                  flash.message = message(code: 'default.updated.message', args: [message(code: 'Contact.label', default: 'Contact'), contactInstance.id])
                  redirect contactInstance
              }
              '*'{ respond contactInstance, [status: OK] }
          }
        }
    }

    @Transactional
    def delete(Contact contactInstance) {

        if (contactInstance == null) {
            notFound()
            return
        }

        contactInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Contact.label', default: 'Contact'), contactInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'contact.label', default: 'Contact'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def prepareEmail(){
      def contact = Contact.findByUuid(params.contactUuid)
      render (view: "prepareEmail", model: [contactInstance: contact, emailInstance: new Email()])
    }

    def saveEmail(String contactUuid, Email emailInstance){
      def contact = Contact.findByUuid(contactUuid)
      try{
        contactService.saveEmail(contact, emailInstance)
        flash.message = message(code:"default.add.label", args:[message(code:'email.label')])
      } catch (ValidationException ve){
        flash.error = message(code: 'error.email.limit')
      }
      redirect action: 'show', id:contact.id
    }

    def prepareTelephone(){
      def contact = Contact.findByUuid(params.contactUuid)
      render (view: "prepareTelephone", model: [contactInstance: contact,telephoneInstance: new Telephone()])
    }

    def saveTelephone(String contactUuid, Telephone telephoneInstance){
      def contact = Contact.findByUuid(contactUuid)
      try{
        contactService.saveTelephone(contact, telephoneInstance)
        flash.message = message(code:"default.add.label", args:[message(code:'telephone.labe')])
      } catch (ValidationException ve){
        flash.error = message(code: 'error.telephone.limit')
      }
      redirect action: 'show', id:contact.id
    }

}
