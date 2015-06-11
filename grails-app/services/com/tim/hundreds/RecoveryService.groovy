package com.tim.hundreds

import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder
import grails.converters.JSON

@Transactional
class RecoveryService {
  def rest = new RestBuilder()

  def generateRegistrationCodeForEmail(String email) {
    def profile = Profile.findByEmail(email)
    def user = User.findByProfile(profile)

    if(!user) throw new BusinessException("User not found")

    def registration = new RegistrationCode(email:email)
    registration.save()

    def message = new ForgotPasswordCommand(email:email, token:registration.token)
    def resp = rest.post("http://localhost:8082/web/services/email/forgotPassword"){
      contentType "application/vnd.org.jfrog.artifactory.security.Group+json"
      body message
    }
    log.info "resp: ${resp.dump()}"
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

