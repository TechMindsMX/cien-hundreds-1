package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
class PhotoController {
    def photoStorerService
    def messengineService
    def photoService

    static showMe = false /*Parametro para aparecer en el menú*/

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

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
          command.path = photoStorerService.storeFile(request.getFile('file'))
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

    def update(PhotoCommand command) {
        if (command.hasErrors()) {
            respond command.errors, view:'edit'
            return
        }

        if(params.file){
          command.path = photoStorerService.storeFile(request.getFile('file'))
        }

        Photo photoInstance = Photo.findByUuid(command.uuid)
        bindData(photoInstance, command)
        messengineService.sendInstanceEditedMessage(photoInstance.musician, 'musician')

        try{
          def instance = photoService.savePhoto(photoInstance)
          request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'photo.label', default: 'Photo'), instance.id])
                redirect instance
            }
            '*' { respond instance, [status: OK] }
          }
        } catch (Exception ve){
          log.info "Errors ${ve.errors}"
          respond photoInstance.musician.errors, view:'create'
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
