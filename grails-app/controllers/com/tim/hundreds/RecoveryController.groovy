package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class RecoveryController {
  def recoveryService

  static showMe = false /*Parametro para aparecer en el menú*/

  def index() { }

  def user() {}

  def show() {
    try {
      recoveryService.obtainRegistrationCodeForToken(params.token)
      respond OK
    }catch(BusinessException be) {
      render status:NOT_FOUND
    }
  }

  def confirm() {
    try {
      recoveryService.confirmAccountForToken(params.token)
      flash.message = g.message(code: 'login.confirm')
      redirect controller:'login', action:'auth'
    }catch(BusinessException be) {
      flash.error = g.message(code: 'login.notfound')
      render status:NOT_FOUND
    }
  }

  def recoveryUser(){
    try{
      recoveryService.recoveryUser(params.email)
      flash.message = g.message(code: 'login.email')
      redirect url:'/'
    }catch(BusinessException be) {
      flash.error = g.message(code: 'login.notfound')
      redirect action:'user'
    }
  }

  def save() {
    def email = params.email
    try {
      recoveryService.generateRegistrationCodeForEmail(email)
      flash.message = g.message(code: 'login.email')
      redirect url:'/'
    } catch(BusinessException be) {
      flash.error = g.message(code: 'login.notfound')
      redirect action:'index'
    } catch(Exception ex) {
      flash.error = g.message(code: 'login.email.unavailable')
      redirect action:'index'
    }

  }

  def update(ChangePasswordCommand command) {
    if(command.hasErrors()) {
      respond command.errors, view:'show', id:params.id
      return
    }
    try {
      recoveryService.changePasswordForToken(params.id, command.password)
      redirect controller:'login', action:'auth'
    } catch(BusinessException be) {
      flash.error = g.message(code: 'login.token.expired')
      redirect action:'index'
    }
  }

}

class ChangePasswordCommand {
  String password
  String confirmPassword

  static constraints = {
    password(blank:false, size:10..50, matches:/^(?=.*\d)(?=.*[=_\-¿?¡!@#\$%^&*]+)?(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/,validator:{val, obj ->
      if(!val.equalsIgnoreCase(obj.confirmPassword)) {
        return false
      }
    })
  }
}
