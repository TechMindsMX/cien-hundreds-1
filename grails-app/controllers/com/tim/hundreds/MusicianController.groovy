package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityUtils

@Secured(['ROLE_USER'])
class MusicianController {
    def logoStorerService
    def musicianService
    def messengineService
    def tagService
    def finderService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_FACILITATOR','ROLE_MUSICIAN_ADMIN','ROLE_MUSICIAN_VIEWER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def musicianList = musicianService.getMusicianList(springSecurityService.currentUser, params)
        respond musicianList.list, model:[musicianInstanceCount: musicianList.count]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_FACILITATOR','ROLE_MUSICIAN_ADMIN','ROLE_MUSICIAN_VIEWER'])
    def creationReportFilter() {
      log.info "Listing musician created from ${params.from} to ${params.to}"
      def musicianList
      try{
        Date startDate = Date.parse('dd-MM-yyyy', params.from)
        Date endDate = Date.parse('dd-MM-yyyy', params.to)
        musicianList = musicianService.getMusiciansByDateCreated(startDate, endDate)
      }catch(InvalidParamsException ipe){
        log.warn ipe.message
        flash.error=g.message(code: 'error.date.range')
      }
      render view:'creationReportView', model: [musicianInstanceList: musicianList]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_FACILITATOR','ROLE_MUSICIAN_ADMIN','ROLE_MUSICIAN_VIEWER'])
    def creationReportView() {
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_FACILITATOR','ROLE_MUSICIAN_ADMIN','ROLE_MUSICIAN_VIEWER'])
    def show(Musician musicianInstance) {
      log.info "musician: ${musicianInstance.dump()}"
      log.info "musicianUuid: ${params.musicianUuid}"
        musicianInstance = finderService.findMusician(musicianInstance, params)
        if(SpringSecurityUtils.ifAnyGranted('ROLE_ADMIN,ROLE_FACILITATOR,ROLE_MUSICIAN_ADMIN,ROLE_MUSICIAN_VIEWER') || springSecurityService.currentUser == musicianInstance.user) {
            respond musicianInstance
        } else {
            flash.error = 'access.denied.label'
            redirect url: '/'
        }
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
          command.logoPath = logoStorerService.storeFile(request.getFile('logo'))
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
        DataBinder.copy(musicianInstance, command)
        musicianService.save(musicianInstance)

        tagService.dropTags(musicianInstance)
        tagService.addTags(musicianInstance, "${command.tagsComma}")
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
