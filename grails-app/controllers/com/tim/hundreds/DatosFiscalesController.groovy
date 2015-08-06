package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_REMEMBERED'])
@Transactional(readOnly = true)
class DatosFiscalesController {
    def datosFiscalesContextService
    def modelContextService
    def messengineService

    static showMe = false /*Parametro para aparecer en el menú*/

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DatosFiscales.list(params), model:[datosFiscalesInstanceCount: DatosFiscales.count()]
    }

    def show(DatosFiscales datosFiscalesInstance) {
        datosFiscalesInstance = datosFiscalesInstance ?: DatosFiscales.findByUuid(params.uuid)
        respond datosFiscalesInstance
    }

    @Secured(['ROLE_USER'])
    def create() {
      def datosFiscalesInstance = new DatosFiscales(params)
      datosFiscalesInstance = modelContextService.setParent(datosFiscalesInstance, params)
      respond datosFiscalesInstance
    }

    @Secured(['ROLE_USER'])
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

    @Secured(['ROLE_USER'])
    def edit(DatosFiscales datosFiscalesInstance) {
        datosFiscalesInstance = DatosFiscales.findByUuid(params.uuid)
        respond datosFiscalesInstance
    }

    @Secured(['ROLE_USER'])
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
        String instance = modelContextService.getInstanceFromDatosFiscales(datosFiscalesInstance)
        messengineService.sendInstanceEditedMessage(datosFiscalesInstance."${instance}", instance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'DatosFiscales.label', default: 'DatosFiscales'), datosFiscalesInstance.id])
                redirect datosFiscalesInstance
            }
            '*'{ respond datosFiscalesInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_USER'])
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
