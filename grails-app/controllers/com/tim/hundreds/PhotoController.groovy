package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
class PhotoController {
    def photoStorerService
    def photoService

    static hideMe = true /*Parametro para que NO aparezca en el menú*/

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Photo.list(params), model:[photoInstanceCount: Photo.count()]
    }

    def show(Photo photoInstance) {
        respond photoInstance
    }

    def create() {
        respond new Photo(params)
    }

    def save(PhotoCommand command) {
        log.info "command: ${command.dump()}"
        if (command.hasErrors()) {
            respond command.errors, view:'create'
            return
        }

        if(params.file){
          def photoPath = photoStorerService.storeFile(request.getFile('file'))
          command.path = photoPath
        }
        Photo photoInstance = new Photo()
        bindData(photoInstance, command)

        try{
          def instance = photoService.savePhoto(photoInstance)
          request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'photo.label', default: 'Photo'), instance.id])
                redirect instance
            }
            '*' { respond instance, [status: CREATED] }
          }
        } catch (Exception ve){
          log.info "Errors ${ve.errors}"
          respond photoInstance.musician.errors, view:'create'
        }
    }

    def edit(Photo photoInstance) {
        respond photoInstance
    }

    @Transactional
    def update(Photo photoInstance) {
        if (photoInstance == null) {
            notFound()
            return
        }

        if (photoInstance.hasErrors()) {
            respond photoInstance.errors, view:'edit'
            return
        }

        photoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Photo.label', default: 'Photo'), photoInstance.id])
                redirect photoInstance
            }
            '*'{ respond photoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Photo photoInstance) {

        if (photoInstance == null) {
            notFound()
            return
        }

        photoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Photo.label', default: 'Photo'), photoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'photo.label', default: 'Photo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
