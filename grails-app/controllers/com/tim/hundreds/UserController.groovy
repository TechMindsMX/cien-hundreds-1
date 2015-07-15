package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class UserController {

  static defaultAction = "create"
  static allowedMethods = [save:'POST']
  static showMe = true

  def userService
  def springSecurityService
  def userPermissionsService

  def show(User userInstance) {
    respond userInstance
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
      def profile = new Profile(email:command.email, firstName:command.firstName, middleName:command.middleName, lastName:command.lastName, phone:command.phone)
      profile.role = "ROLE_USER"
      user.profile = profile
      userService.create(user)

      flash.message = "Su usuario ha sido creado y se ha enviado un correo electrónico"
      respond command, view: 'create'
    } catch(DuplicatedEmailException de){
      flash.error = "El correo ya pertenece a otro usuario"
      respond command, view: 'create'
    } catch(BusinessException be){
      flash.error = "El servicio de correo no está disponible"
      respond command, view: 'create'
    }

  }

  @Secured(['ROLE_ADMIN', 'ROLE_MUSICIAN_ADMIN', 'ROLE_COMPANY_ADMIN'])
  def status(User userInstance) {

    try {
      userPermissionsService.canEditUserStatus(springSecurityService.currentUser, userInstance)
    } catch (InvalidPermissionsException e) {
      flash.error = message(code: 'access.denied.label', args: [message(code: e.message)])
      redirect url:'/'
    }

    respond userInstance
  }

  @Secured(['ROLE_ADMIN', 'ROLE_MUSICIAN_ADMIN', 'ROLE_COMPANY_ADMIN'])
  def statusUpdate(User userInstance) {

    try {
      userPermissionsService.canEditUserStatus(springSecurityService.currentUser, userInstance)
    } catch (InvalidPermissionsException e) {
      flash.error = message(code: 'access.denied.label', args: [message(code: e.message)])
      redirect url:'/'
    }

    if (userInstance == null) {
        notFound()
        return
    }

    if (userInstance.hasErrors()) {
        respond userInstance.errors, view:'status'
        return
    }

    userInstance.save flush:true

    request.withFormat {
        form multipartForm {
            flash.message = message(code: 'default.updated.message', args: [message(code: 'User.label', default: 'Usuario'), userInstance.id])
            redirect userInstance
        }
        '*'{ respond userInstance, [status: OK] }
    }
  }

}
