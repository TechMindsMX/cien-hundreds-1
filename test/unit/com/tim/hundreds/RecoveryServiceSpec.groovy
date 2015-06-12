package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(RecoveryService)
class RecoveryServiceSpec extends Specification {
  def restService = Mock(RestService)
  def recoveryCollaboratorService = Mock(RecoveryCollaboratorService)
  def userHelperService = Mock(UserHelperService)
  def registrationHelperService = Mock(RegistrationHelperService)

  def setup() {
    service.restService = restService
    service.userHelperService = userHelperService
    service.recoveryCollaboratorService = recoveryCollaboratorService
    service.registrationHelperService = registrationHelperService
  }

  void "should generate registration code for email"() {
  given: "An email"
    def email = 'josdem@email.com'
  and: "User mock"
    def user = Mock(User)
    def message = Mock(TokenCommand)
  when: "We find user by email"
    userHelperService.findByEmail(email) >> user
    recoveryCollaboratorService.generateToken(email) >> message
    service.generateRegistrationCodeForEmail(email)
  then: "We expect send message to the email service"
    1 * restService.sendCommand(message, ApplicationState.FORGOT_PASSWORD_URL)
  }

  void "should not generate registration code for email since user not found"() {
  given: "An email"
    def email = 'josdem@email.com'
  when: "We find user by email"
    service.generateRegistrationCodeForEmail(email)
  then: "We expect send message to the email service"
    thrown BusinessException
  }

  void "should change password for token"(){
  given: "Token and password"
    def token = 'token'
    def password = 'password'
    def email = 'josdem@email.com'
  and: "user"
    def user = Mock(User)
  when: "We send change password for token"
    service.changePasswordForToken(token, password)
  then: "We expect save new password"
    registrationHelperService.findEmailByToken(token) >> email
    userHelperService.findByEmail(email) >> user
    1 * user.setProperty('password','password')
    1 * user.save()
  }

  void "should not change password for token since user not exist"(){
  given: "Token and password"
    def token = 'token'
    def password = 'password'
    def email = 'josdem@email.com'
  and: "user"
    def user = Mock(User)
  when: "We send change password for token"
    service.changePasswordForToken(token, password)
  then: "We expect save new password"
    registrationHelperService.findEmailByToken(token) >> email
    thrown BusinessException
  }
}
