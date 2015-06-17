package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class FacilitatorController {
  def userService
  def photoStorerService
  def resumeStorerService

  def index(){
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
      render(template:'/user/form', model:[command:command])
      return
    }

    def User user = new User(username: command.username, password: command.password)
    def profile = new Profile(email:command.email, firstName:command.firstName, middleName:command.middleName, lastName:command.lastName)
    // profile.save(validation: false)
    profile.role = command.role
    log.info "el profile: ${profile?.dump()}"

    if(params.photo){
      def photoPath = photoStorerService.storeFile(request.getFile('photo'))
      profile.photoPath = photoPath
    }
    if(params.resume){
      def resumePath = resumeStorerService.storeFile(request.getFile('resume'))
      profile.resumePath = resumePath
    }

    user.profile = profile
    userService.create(user)
  }
}
