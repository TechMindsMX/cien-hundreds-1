package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class UserController {
  def userService

  def save(UserCommand command){
    log.info "Creating user: ${command?.dump()}"
    if(command.hasErrors()){
      respond command.errors, view: 'save'
    } else {
      def User user = new User(username: command.username, password: command.password)
      def profile = new Profile(email:command.email, firstName:command.firstName, middleName:command.middleName, lastName:command.lastName)
      user.profile = profile
      userService.create(user)
      redirect(uri:'/')
    }
  }
}
