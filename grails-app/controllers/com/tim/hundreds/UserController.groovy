package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class UserController {
  def userService

  def create(User user){
    log.info "Creating user: ${user?.dump()}"
    userService.create(user)
  }

}
