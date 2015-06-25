package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class FacilitatorController {

  static defaultAction = "create"

  static showMe = true /*Parametro para aparecer en el menú*/

  def userService
  def photoStorerService
  def resumeStorerService

  def index(){
  }

  def create(){
    UserCommand command = new UserCommand()
    respond command
  }

  def save(UserCommand command){
    log.info "Creating facilitator(user): ${command?.dump()}"
    if(command.hasErrors()){
      respond command, model:[model: command], view: 'create'
      return
    }

    try{
      def user = new User(username: command.username, password: command.password)
      def profile = new Profile(email:command.email, firstName:command.firstName, middleName:command.middleName, lastName:command.lastName)
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

      flash.message = "Su facilitador ha sido creado y se ha enviado un correo electrónico"
      respond command, view: 'create'
    } catch(BusinessException be){
      flash.error = "El servicio de correo no está disponible"
      respond command, view: 'create'
    }
  }

}
