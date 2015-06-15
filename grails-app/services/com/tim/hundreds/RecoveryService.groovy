package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class RecoveryService {
  def restService
  def userHelperService
  def registrationHelperService
  def recoveryCollaboratorService

  def generateRegistrationCodeForEmail(String email) {
    def user = userHelperService.findByEmail(email)
    if(!user) throw new BusinessException("User not found")

    def message = recoveryCollaboratorService.generateToken(email)
    restService.sendCommand(message, ApplicationState.FORGOT_PASSWORD_URL)
  }

  def changePasswordForToken(token, password){
    log.info "token: ${token}"
    log.info "valid?: ${registrationHelperService.isValidToken(token)}"

    if(!registrationHelperService.isValidToken(token)) throw new BusinessException("Not valid token")
    recoveryCollaboratorService.saveRegistrationCode(token)

    def user = getUserByToken(token)
    if(!user) throw new BusinessException("User not found")

    user.password = password
    user.save()
  }

  def confirmAccountForToken(token){
    def user = getUserByToken(token)
    if(!user) throw new BusinessException("User not found")

    user.enabled = true
    user.save()

    def name = "${user.profile.firstName} ${user.profile.middleName} ${user.profile.lastName}"
    def message = new NameCommand(email:user.profile.email, name:name)
    restService.sendCommand(message, ApplicationState.NEW_USER_URL)
  }

  def recoveryUser(String email){
    def user = userHelperService.findByEmail(email)
    if(!user) throw new BusinessException("User not found")

    def message = new NameCommand(email:email, name:"${user.username[0..2]}***")
    restService.sendCommand(message, ApplicationState.FORGOT_USERNAME_URL)
  }

  def obtainRegistrationCodeForToken(token) {
    recoveryCollaboratorService.findRegistrationCode(token)
  }

  def sendConfirmationAccountToken(String email){
    def message = recoveryCollaboratorService.generateToken(email)
    restService.sendCommand(message, ApplicationState.REGISTER_URL)
  }

  def getUserByToken(String token){
    def email = registrationHelperService.findEmailByToken(token)
    def user = userHelperService.findByEmail(email)

    user
  }

}

