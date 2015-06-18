package com.tim.hundreds

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class RecoveryController {
  def recoveryService

  static hideMe = true /*Parametro para que NO aparezca en el menú*/

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
      redirect controller:'login', action:'auth'
    }catch(BusinessException be) {
      render status:NOT_FOUND
    }
  }

  def recoveryUser(){
    try{
      recoveryService.recoveryUser(params.email)
      flash.message = "Un mensaje se te ha enviado al correo"
      redirect controller:'login', action:'auth'
    }catch(BusinessException be) {
      flash.error = "No hemos encontrado ese correo en nuestros registros"
      redirect action:'user'
    }
  }

  def save() {
    def email = params.email
    try {
      recoveryService.generateRegistrationCodeForEmail(email)
      flash.message = "Un mensaje se te ha enviado al correo"
      redirect action:'index'
    } catch(BusinessException be) {
      flash.error = "No hemos encontrado ese correo en nuestros registros"
      redirect action:'index'
    } catch(Exception ex) {
      flash.error = "El servicio de correo no esta disponible"
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
      flash.error = "El token ha expirado"
      redirect action:'index'
    }
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
