package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class UserController {
  def userService

  def save(UserCommand command){
    if(command.username){
      log.info "Creating user: ${command?.dump()}"
      if(!command.hasErrors()){
        def User user = new User(username: command.username, password: command.password)
        def profile = new Profile(email:command.email, firstName:command.firstName, middleName:command.middleName, lastName:command.lastName)
        user.profile = profile
        userService.create(user)
      }
    }
  }
}
