package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class FacilitatorController {
  def userService
  def storerService

  def index(){
    respond new UserCommand()
  }

  def create(){
    respond new UserCommand()
  }

  def save(UserCommand command){
    log.info "Creating user: ${command?.dump()}"
    if(command == null){
      notFound()
      return
    }

    if(command.hasErrors()){
      respond command.errors, view: 'save'
      return
    }

    def User user = new User(username: command.username, password: command.password)
    def profile = new Profile(email:command.email, firstName:command.firstName, middleName:command.middleName, lastName:command.lastName)
    profile.role = command.role

    if(params.photo){
      def photoPath = storerService.storeFile(request.getFile('photo'))
      profile.photoPath = photoPath
    }

    user.profile = profile
    userService.create(user)
  }
}
