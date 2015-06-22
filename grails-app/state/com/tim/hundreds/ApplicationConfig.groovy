package com.tim.hundreds

class ApplicationConfig {
  def grailsApplication

  final String forgotPasswordUrl = grailsApplication.config.forgot.password.url
}
