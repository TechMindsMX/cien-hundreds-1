package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class SocialController {
  def musicianService
  def socialContextService
  def modelContextService

  static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

  def index(Integer max) {
    params.max = Math.min(max ?: 10, 100)
    respond Social.list(params), model:[socialInstanceCount: Social.count()]
  }

  @Secured(['IS_AUTHENTICATED_REMEMBERED'])
  def show(Social socialInstance) {
    socialInstance = Social.findByUuid(params.uuid)
    respond socialInstance
  }

  def create() {
    def socialInstance = new Social(params)
    socialInstance = modelContextService.setParent(socialInstance, params)
    respond socialInstance
  }

  @Transactional
  def save(Social socialInstance) {
    if (socialInstance == null) {
      notFound()
      return
    }

    socialInstance = modelContextService.setParent(socialInstance, params)

    if (socialInstance.hasErrors()) {
      respond socialInstance.errors, view:'create'
      return
    }

    socialContextService.saveInstance(socialInstance)

    request.withFormat {
      form multipartForm {
        flash.message = message(code: 'default.created.message', args: [message(code: 'social.label', default: 'Social'), socialInstance.id])
        redirect action: 'show', params: [uuid: socialInstance.uuid]
      }
      '*' { respond socialInstance, [status: CREATED] }
    }
  }

  def edit(Social socialInstance) {
    socialInstance = Social.findByUuid(params.uuid)
    respond socialInstance
  }

  @Transactional
  def update(Social socialInstance) {
    if (socialInstance == null) {
      notFound()
      return
    }

    if (socialInstance.hasErrors()) {
      respond socialInstance.errors, view:'edit'
      return
    }

    socialInstance.save flush:true

    request.withFormat {
      form multipartForm {
        flash.message = message(code: 'default.updated.message', args: [message(code: 'Social.label', default: 'Social'), socialInstance.id])
        redirect action: 'show', params: [uuid: socialInstance.uuid]
      }
      '*'{ respond socialInstance, [status: OK] }
    }
  }

  @Transactional
  def delete(Social socialInstance) {

    if (socialInstance == null) {
      notFound()
      return
    }

    socialContextService.deleteInstance(socialInstance)

    request.withFormat {
      form multipartForm {
        flash.message = message(code: 'default.deleted.message', args: [message(code: 'Social.label', default: 'Social'), socialInstance.id])
        modelContextService.getParamsForRedirectOnDelete(socialInstance, request)
        redirect controller: request.controller, action:"show", params: [uuid: request.uuid]
       }
      '*'{ render status: NO_CONTENT }
    }
  }

  protected void notFound() {
    request.withFormat {
      form multipartForm {
        flash.message = message(code: 'default.not.found.message', args: [message(code: 'social.label', default: 'Social'), params.id])
        redirect action: "index", method: "GET"
      }
      '*'{ render status: NOT_FOUND }
    }
  }


}
