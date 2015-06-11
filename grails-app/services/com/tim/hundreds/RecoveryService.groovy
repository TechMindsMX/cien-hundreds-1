package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class RecoveryService {
  def restService

  def generateRegistrationCodeForEmail(String email) {
    def profile = Profile.findByEmail(email)
    def user = User.findByProfile(profile)
    if(!user) throw new BusinessException("User not found")

    def message = generateToken(email)
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
    def registrationCode = saveRegistrationCode(token)
    def profile = Profile.findByEmail(registrationCode.email)

    def user = User.findByProfile(profile)
    user.enabled = true
    user.save()
  }

  def obtainRegistrationCodeForToken(token) {
    saveRegistrationCode(token)
  }

  def sendConfirmationAccountToken(String email){
    def message = generateToken(email)
    restService.sendCommand(message, ApplicationState.REGISTER_URL)
  }

  def generateToken(String email){
    def registration = new RegistrationCode(email:email)
    registration.save()
    def message = new TokenCommand(email:email, token:registration.token)
    message
  }

  def saveRegistrationCode(token){
    def registrationCode = RegistrationCode.findByTokenAndStatus(token, RegistrationCodeStatus.VALID)
    if(!registrationCode) throw new BusinessException("User not found")
    registrationCode.status = RegistrationCodeStatus.INVALID
    registrationCode.save()

    registrationCode
  }

}

