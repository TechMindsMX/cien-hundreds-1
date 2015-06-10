package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class RecoveryController {
  def recoveryService

  def index() { }

  def show() {
    try {
      recoveryService.obtainRegistrationCodeForToken(params.id)
      respond OK
    }catch(BusinessException be) {
      render status:NOT_FOUND
    }
  }

  def save() {
    def email = params.email
    try {
      recoveryService.generateRegistrationCodeForEmail(email)
      flash.message = "Un mensaje se te ha enviado al correo"
      redirect action:'index'
    }catch(BusinessException be) {
      flash.error = "Hubo un problema con el correo indicado"
      redirect action:'index'
    }
  }

  def update(ChangePasswordCommand command) {
    if(command.hasErrors()) {
      respond command.errors, view:'show', id:params.id
      return
    }
    recoveryService.changePasswordForToken(params.id, command.password)
    redirect controller:'login', action:'auth'
  }

}

class ChangePasswordCommand {
  String password
  String confirmPassword

  static constraints = {
    password(blank:false, size:10..50, matches:/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{10,}$/,validator:{val, obj ->
      if(!val.equalsIgnoreCase(obj.confirmPassword)) {
        return false
      }
    })
  }
}
