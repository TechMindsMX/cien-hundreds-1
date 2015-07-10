package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN','ROLE_MUSICIAN_ADMIN','ROLE_COMPANY_ADMIN'])
class FacilitatorController {

  static defaultAction = "create"
  static allowedMethods = [save:'POST']
  static showMe = true

  def userService
  def photoStorerService
  def resumeStorerService

  def index() {
    redirect(controller: "userManagement", action: "index")
  }

  def create(){
    UserCommand command = new UserCommand()
    respond command
  }

  def save(UserCommand command){
    log.info "Creating user: ${command?.dump()}"
    if(command.hasErrors()){
      render(view:'create', model:[model:command])
      return
    }

    try{
      def user = new User(username: command.username, password: command.password)
      def profile = new Profile(email:command.email, firstName:command.firstName, middleName:command.middleName, lastName:command.lastName)
      user.accountExpired = !command.status
      profile.role = command.role
      profile.save()
      user.profile = profile
      userService.create(user)

      if(!params.photo.isEmpty()){
        def photoPath = photoStorerService.storeFile(request.getFile('photo'))
        profile.photoPath = photoPath
      }
      if(!params.resume.isEmpty()){
        def resumePath = resumeStorerService.storeFile(request.getFile('resume'))
        profile.resumePath = resumePath
      }

      flash.message = "El usuario ha sido creado y se ha enviado un correo electrónico"
      respond command, view: 'create'
    } catch(BusinessException be){
      flash.error = "El servicio de correo no está disponible"
      respond command, view: 'create'
    }
  }

}
