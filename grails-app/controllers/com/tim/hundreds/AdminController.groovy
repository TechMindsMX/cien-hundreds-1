package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN','ROLE_MUSICIAN_ADMIN','ROLE_COMPANY_ADMIN'])
class AdminController {

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
      def profile = new Profile(email:command.email, firstName:command.firstName, motherLastName:command.motherLastName, lastName:command.lastName)
      user.accountExpired = !command.status
      profile.role = command.role
      user.profile = profile
      userService.create(user)

      if(!params.photo.isEmpty()){
        profile.photoPath = photoStorerService.storeFile(request.getFile('photo'))
      }
      if(!params.resume.isEmpty()){
        profile.resumePath = resumeStorerService.storeFile(request.getFile('resume'))
      }

      flash.message = "El usuario ha sido creado y se ha enviado un correo electrónico"
      respond command, view: 'create'
    } catch(DuplicatedEmailException de){
      flash.error = "El correo ya pertenece a otro usuario"
      respond command, view: 'create'
    } catch(BusinessException be){
      flash.error = "El servicio de correo no está disponible"
      respond command, view: 'create'
    }
  }

  def edit() {
    def user = User.findByUuid(params.id)
    def userCommand = new UserCommand()
    userCommand.username = user.username
    userCommand.email = user.profile.email
    userCommand.firstName = user.profile.firstName
    userCommand.lastName = user.profile.lastName
    userCommand.motherLastName = user.profile.motherLastName
    userCommand.phone = user.profile.phone
    userCommand.role = user.profile.role
    userCommand.photoPath = user.profile.photoPath
    userCommand.resumePath = user.profile.resumePath
    userCommand.status = !user.accountExpired
    [model:userCommand]
  }

}
