package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class UserController {

  static defaultAction = "create"
  static allowedMethods = [save:'POST']
  static showMe = true

  def userService

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
      profile.role = "ROLE_USER"
      profile.save()
      user.profile = profile
      userService.create(user)

      flash.message = "Su usuario ha sido creado y se ha enviado un correo electrónico"
      respond command, view: 'create'
    } catch(BusinessException be){
      flash.error = "El servicio de correo no está disponible"
      respond command, view: 'create'
    }
  }

}
