package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class MusicianController {
    def logoStorerService
    def musicianService
    def messengineService
    def tagService

    static showMe = true /*Parametro para aparecer en el menú*/

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_FACILITATOR','ROLE_MUSICIAN_ADMIN','ROLE_MUSICIAN_VIEWER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Musician.list(params), model:[musicianInstanceCount: Musician.count()]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_FACILITATOR','ROLE_MUSICIAN_ADMIN','ROLE_MUSICIAN_VIEWER'])
    def creationReportFilter() {
      log.info "Listing musician created from ${params.from} to ${params.to}"
      if(params.from > params.to){
        flash.error="La fecha de inicio no puede ser mayor a la fecha final"
      }
      render view:'creationReportView', model: [musicianInstance: Musician.list()]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_FACILITATOR','ROLE_MUSICIAN_ADMIN','ROLE_MUSICIAN_VIEWER'])
    def creationReportView() {
      [musicianInstance: Musician.list()]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_FACILITATOR','ROLE_MUSICIAN_ADMIN','ROLE_MUSICIAN_VIEWER'])
    def show(Musician musicianInstance) {
        respond musicianInstance
    }

    def create() {
        respond new Musician(params)
    }

    def save(MusicianCommand command) {
        log.info "${command.dump()}"
        if (command.hasErrors()) {
            Musician musicianInstance = new Musician(params)
            musicianInstance.errors = command.errors
            render view:'create', model: [musicianInstance:musicianInstance]
            return
        }

        if(!params.logo.isEmpty()){
          def logoPath = logoStorerService.storeFile(request.getFile('logo'))
          command.logoPath = logoPath
        }

        Musician musicianInstance = new Musician()
        bindData(musicianInstance, command)
        musicianService.save(musicianInstance)

        tagService.addTags(musicianInstance, "${command.name},${command.genre.name},${command.tagsComma}")

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'musician.label', default: 'Musician'), musicianInstance.id])
                redirect musicianInstance
            }
            '*' { respond musicianInstance, [status: CREATED] }
        }
    }

    def edit(Musician musicianInstance) {
        log.info "${musicianInstance.dump()}"
        respond musicianInstance
    }

    def update(MusicianCommand command) {
        log.info "${command.dump()}"

        if (command.hasErrors()) {
            Musician musicianInstance = new Musician(params)
            musicianInstance.errors = command.errors
            render view:'edit', model: [musicianInstance:musicianInstance]
            return
        }

       if(!params.logo.isEmpty()){
          command.logoPath = logoStorerService.storeFile(request.getFile('logo'))
        }

        def musicianInstance = Musician.findByUuid(command.uuid)
        bindData(musicianInstance, command)
        musicianService.save(musicianInstance)

        tagService.addTags(musicianInstance, "${command.name},${command.genre.name},${command.tagsComma}")
        messengineService.sendInstanceEditedMessage(musicianInstance, 'musician')

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Musician.label', default: 'Musician'), musicianInstance.id])
                redirect musicianInstance
            }
            '*'{ respond musicianInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_MUSICIAN_ADMIN'])
    def delete(Musician musicianInstance) {

        if (musicianInstance == null) {
            notFound()
            return
        }

        musicianInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Musician.label', default: 'Musician'), musicianInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'musician.label', default: 'Musician'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
