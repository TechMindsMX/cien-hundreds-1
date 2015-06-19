package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class UserController {

  static defaultAction = "create"
  def userService

  def index(){
    respond new UserCommand()
  }

  def create(){
    UserCommand command = new UserCommand()
    respond command
  }

  def save(UserCommand command){
    log.info "Creating user: ${command?.dump()}"
    if(command.hasErrors()){
      respond command, model:[model: command], view: 'create'
      return
    }

    try{
      def User user = new User(username: command.username, password: command.password)
      def profile = new Profile(email:command.email, firstName:command.firstName, middleName:command.middleName, lastName:command.lastName)
      profile.role = "ROLE_USER"
      profile.save()
      user.profile = profile
      log.info "user: ${user.dump()}"
      log.info "profile: ${profile.dump()}"

      userService.create(user)

      flash.message = "Su usuario ha sido creado y se ha enviado un correo electrónico"
      respond command, view: 'create'
    } catch(BusinessException be){
      flash.error = "El servicio de correo no está disponible"
      respond command, view: 'create'
    }
  }
}
