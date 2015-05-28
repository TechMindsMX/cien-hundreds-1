package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class UserController {
  def userService

  def save(User userInstance){
    if(userInstance){
      log.info "Creating user: ${userInstance?.dump()}"
      log.info "Params: ${params.dump()}"
      log.info "${params.password} : ${params.passwordCheck}"
      userService.create(userInstance)
    }
  }
}
