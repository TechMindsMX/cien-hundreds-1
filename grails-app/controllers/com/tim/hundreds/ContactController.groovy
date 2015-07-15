package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
class ContactController {
    def photoStorerService
    def contactService
    def tagService

    static showMe = false /*Parametro para aparecer en el menú*/

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Contact.list(params), model:[contactInstanceCount: Contact.count()]
    }

    def show(Contact contactInstance) {
        respond contactInstance
    }

    def create() {
      [
        musicianId : params.musicianId
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

        if(params.file){
          def photoPath = photoStorerService.storeFile(request.getFile('file'))
          command.photoPath = photoPath
        }

        Contact contactInstance = new Contact()
        bindData(contactInstance, command)
        Musician musician = Musician.findById(params.musician.id)
        contactInstance.musician = musician
        tagService.addMusicianTags(musician, "${contactInstance.firstName},${contactInstance.lastName},${contactInstance.motherLastName}")

        try{
          def instance = contactService.save(contactInstance)
          request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'contact.label', default: 'Contact'), instance.id])
                redirect instance
            }
            '*' { respond instance, [status: CREATED] }
          }
        }catch(Exception ex){
          log.info "Errors: ${ex.message}"
          respond contactInstance.musician.errors, view:'create'
        }

    }

    def edit(Contact contactInstance) {
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

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Contact.label', default: 'Contact'), contactInstance.id])
                redirect contactInstance
            }
            '*'{ respond contactInstance, [status: OK] }
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
      def contact = contact.findByUuid(params.contactUuid)
      render (view: "prepareEmail", model: [contactInstance: contact, emailInstance: new Email()])
    }

    def saveEmail(String contactUuid, Email emailInstance){
      def contact = contact.findByUuid(contactUuid)
      contactService.saveEmail(contact, emailInstance)
      redirect(uri: "/email/index")
    }

    def prepareTelephone(){
      def contact = contact.findByUuid(params.contactUuid)
      render (view: "prepareTelephone", model: [contactInstance: contact,telephoneInstance: new Telephone()])
    }

    def saveTelephone(String contactUuid, Telephone telephoneInstance){
      def contact = contact.findByUuid(contactUuid)
      contactService.saveTelephone(contact, telephoneInstance)
      redirect(uri: "/telephone/index")
    }

}
