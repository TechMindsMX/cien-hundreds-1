package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class RecoveryService {
  def restService
  def userHelperService
  def recoveryCollaboratorService

  def generateRegistrationCodeForEmail(String email) {
    def user = userHelperService.findByEmail(email)
    if(!user) throw new BusinessException("User not found")

    def message = recoveryCollaboratorService.generateToken(email)
    restService.sendCommand(message, ApplicationState.FORGOT_PASSWORD_URL)
  }

  def changePasswordForToken(token, password){
    def registrationCode = RegistrationCode.findByToken(token)
    def profile = Profile.findByEmail(registrationCode.email)

    def user = User.findByProfile(profile)
    user.password = password
    user.save()

    user
  }

  def confirmAccountForToken(token){
    def registrationCode = recoveryCollaboratorService.saveRegistrationCode(token)
    def profile = Profile.findByEmail(registrationCode.email)

    def user = User.findByProfile(profile)
    user.enabled = true
    user.save()

    def name = "${profile.firstName} ${profile.middleName} ${profile.lastName}"
    def message = new NameCommand(email:registrationCode.email, name:name)
    restService.sendCommand(message, ApplicationState.NEW_USER_URL)
  }

  def obtainRegistrationCodeForToken(token) {
    recoveryCollaboratorService.saveRegistrationCode(token)
  }

  def sendConfirmationAccountToken(String email){
    def message = recoveryCollaboratorService.generateToken(email)
    restService.sendCommand(message, ApplicationState.REGISTER_URL)
  }

}

