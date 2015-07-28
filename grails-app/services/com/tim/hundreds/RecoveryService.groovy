package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class RecoveryService {
  def restService
  def userHelperService
  def registrationHelperService
  def recoveryCollaboratorService
  def grailsApplication

  def generateRegistrationCodeForEmail(String email) {
    def user = userHelperService.findByEmail(email)
    if(!user) throw new BusinessException("User not found")
    if(!user.activated) throw new BusinessException("Account is not activated")

    def message = recoveryCollaboratorService.generateToken(email)
    restService.sendCommand(message, grailsApplication.config.forgot.password.url)
  }

  def changePasswordForToken(token, password){
    if(!registrationHelperService.isValidToken(token)) throw new BusinessException("Not valid token")
    recoveryCollaboratorService.saveRegistrationCode(token)

    def user = getUserByToken(token)
    if(!user) throw new BusinessException("User not found")

    user.password = password
    user.accountLocked = false
    user.save()
  }

  def confirmAccountForToken(token){
    def user = getUserByToken(token)
    if(!user) throw new BusinessException("User not found")

    user.enabled = true
    user.save()

    def name = "${user.profile.firstName} ${user.profile.motherLastName} ${user.profile.lastName}"
    def message = new NameCommand(email:user.profile.email, name:name)
    restService.sendCommand(message, grailsApplication.config.newUser.url)
  }

  def recoveryUser(String email){
    def user = userHelperService.findByEmail(email)
    if(!user) throw new BusinessException("User not found")

    def message = new NameCommand(email:email, name:"${user.username[0..2]}***")
    restService.sendCommand(message, grailsApplication.config.forgot.username.url)
  }

  def obtainRegistrationCodeForToken(token) {
    recoveryCollaboratorService.findRegistrationCode(token)
  }

  def sendConfirmationAccountToken(String email){
    def message = recoveryCollaboratorService.generateToken(email)
    restService.sendCommand(message, grailsApplication.config.register.url)
  }

  def getUserByToken(String token){
    def email = registrationHelperService.findEmailByToken(token)
    def user = userHelperService.findByEmail(email)

    user
  }

}

