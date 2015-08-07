package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_REMEMBERED'])
@Transactional(readOnly = true)
class AddressController {
    def addressContextService
    def modelContextService
    def messengineService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Address.list(params), model:[addressInstanceCount: Address.count()]
    }

    def show(Address addressInstance) {
        addressInstance = addressInstance ?: Address.findByUuid(params.uuid)
        respond addressInstance
    }

    @Secured(['ROLE_USER'])
    def create() {
      def addressInstance = new Address(params)
      addressInstance = modelContextService.setParent(addressInstance, params)
      respond addressInstance
    }

    @Secured(['ROLE_USER'])
    @Transactional
    def save(Address addressInstance) {
        log.info "address: ${addressInstance.dump()}"
        if (addressInstance == null) {
            notFound()
            return
        }

        addressInstance = modelContextService.setParent(addressInstance, params)

        if (addressInstance.hasErrors()) {
            respond addressInstance.errors, view:'create'
            return
        }

        addressContextService.saveInstance(addressInstance)

        request.withFormat {
          form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'address.label', default: 'Address'), addressInstance.id])
                redirect action: "show", params:[uuid: addressInstance.uuid]
            }
            '*' { respond addressInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_USER'])
    def edit(Address addressInstance) {
        addressInstance = Address.findByUuid(params.uuid)
        respond addressInstance
    }

    @Secured(['ROLE_USER'])
    @Transactional
    def update(Address addressInstance) {
        if (addressInstance == null) {
            notFound()
            return
        }

        if (addressInstance.hasErrors()) {
            respond addressInstance.errors, view:'edit'
            return
        }

        addressInstance.save flush:true
        String instance = modelContextService.getInstanceFromChild(addressInstance)
        messengineService.sendInstanceEditedMessage(addressInstance."${instance}", instance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Address.label', default: 'Address'), addressInstance.id])
                redirect action: "show", params:[uuid: addressInstance.uuid]
            }
            '*'{ respond addressInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_USER'])
    @Transactional
    def delete(Address addressInstance) {

        if (addressInstance == null) {
            notFound()
            return
        }

        addressContextService.deleteInstance(addressInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Address.label', default: 'Address'), addressInstance.id])
                modelContextService.getParamsForRedirectOnDelete(addressInstance, request)
                redirect controller: request.controller, action:"show", params: [uuid: request.uuid]
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'address.label', default: 'Address'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }


}
