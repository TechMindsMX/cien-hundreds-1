package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class RecoveryService {
  def restService

  def generateRegistrationCodeForEmail(String email) {
    def profile = Profile.findByEmail(email)
    def user = User.findByProfile(profile)
    if(!user) throw new BusinessException("User not found")

    def registration = new RegistrationCode(email:email)
    registration.save()

    def message = new ForgotPasswordCommand(email:email, token:registration.token)
    restService.send(message)

    registration
  }

  def changePasswordForToken(token, password) {
    def registrationCode = RegistrationCode.findByToken(token)
    def profile = Profile.findByEmail(registrationCode.email)

    def user = User.findByProfile(profile)
    user.password = password
    user.save()

    user
  }

  def obtainRegistrationCodeForToken(token) {
    def registrationCode = RegistrationCode.findByTokenAndStatus(token, VALID)
    if(!registrationCode) throw new BusinessException("User not found")
      registrationCode.status = RegistrationCodeStatus.INVALID
      registrationCode.save()
      registrationCode
  }

}

