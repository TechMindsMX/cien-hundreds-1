package com.tim.hundreds

class RegistrationCode {
  String token = TokenService.generateToken()
  Long timestamp = new Date().getTime()
  String email

  Date dateCreated

  RegistrationCodeStatus status = RegistrationCodeStatus.VALID

  static mapping = {
    version false
  }

  def isValid(){
    log.info "time: ${new Date().getTime() - timestamp}"
    log.info "minus: ${ApplicationState.MILISECONDS * ApplicationState.TIME_UNIT * ApplicationState.TIMEOUT}"
    (new Date().getTime() - timestamp < ApplicationState.MILISECONDS * ApplicationState.TIME_UNIT * ApplicationState.TIMEOUT) && status == RegistrationCodeStatus.VALID ? true : false;
  }

}
