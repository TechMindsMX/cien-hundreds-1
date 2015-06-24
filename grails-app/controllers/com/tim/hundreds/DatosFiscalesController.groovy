package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
@Transactional(readOnly = true)
class DatosFiscalesController {
    def datosFiscalesContextService

    static hideMe = true /*Parametro para que NO aparezca en el menú*/

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DatosFiscales.list(params), model:[datosFiscalesInstanceCount: DatosFiscales.count()]
    }

    def show(DatosFiscales datosFiscalesInstance) {
        respond datosFiscalesInstance
    }

    def create() {
      [
        musicianUuidd : params.musicianUuid,
        companyUuid : params.companyUuid
      ]
    }

    @Transactional
    def save(DatosFiscales datosFiscalesInstance) {
        log.info "datosFiscalesInstance: ${datosFiscalesInstance.dump()}"
        if (datosFiscalesInstance == null) {
            notFound()
            return
        }

        if (datosFiscalesInstance.hasErrors()) {
            respond datosFiscalesInstance.errors, view:'create'
            return
        }

        datosFiscalesContextService.saveInstance(datosFiscalesInstance, params)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'datosFiscales.label', default: 'DatosFiscales'), datosFiscalesInstance.id])
                redirect datosFiscalesInstance
            }
            '*' { respond datosFiscalesInstance, [status: CREATED] }
        }
    }

    def edit(DatosFiscales datosFiscalesInstance) {
        respond datosFiscalesInstance
    }

    @Transactional
    def update(DatosFiscales datosFiscalesInstance) {
        if (datosFiscalesInstance == null) {
            notFound()
            return
        }

        if (datosFiscalesInstance.hasErrors()) {
            respond datosFiscalesInstance.errors, view:'edit'
            return
        }

        datosFiscalesInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'DatosFiscales.label', default: 'DatosFiscales'), datosFiscalesInstance.id])
                redirect datosFiscalesInstance
            }
            '*'{ respond datosFiscalesInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(DatosFiscales datosFiscalesInstance) {

        if (datosFiscalesInstance == null) {
            notFound()
            return
        }

        datosFiscalesContextService.deleteInstance(datosFiscalesInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'DatosFiscales.label', default: 'DatosFiscales'), datosFiscalesInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'datosFiscales.label', default: 'DatosFiscales'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
