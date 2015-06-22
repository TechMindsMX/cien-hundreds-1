package com.tim.hundreds

class ApplicationConfigService {
  def grailsApplication

  String registerUrl = grailsApplication.config.register.url
  String newUserUrl = grailsApplication.config.newuser.url
  String forgotPasswordUrl = grailsApplication.config.forgot.password.url
}
