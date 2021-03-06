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
    grailsApplication.config.forgot.password.url = 'forgotPasswordUrl'
    grailsApplication.config.newUser.url = 'newUserUrl'
    grailsApplication.config.forgot.username.url = 'forgotUsernameUrl'
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
    user.enabled >> true
    service.generateRegistrationCodeForEmail(email)
  then: "We expect send message to the email service"
    1 * restService.sendCommand(message, 'forgotPasswordUrl')
  }

  void "should not generate registration code for email since user not found"() {
  given: "An email"
    def email = 'josdem@email.com'
  when: "We find user by email"
    service.generateRegistrationCodeForEmail(email)
  then: "We expect send message to the email service"
    thrown UserNotFoundException
  }

  void "should not generate registration code for email since account is not activated"() {
  given: "An email"
    def email = 'josdem@email.com'
  and: "User mock"
    def user = Mock(User)
  when: "We find user by email"
    userHelperService.findByEmail(email) >> user
    user.enabled >> false
    service.generateRegistrationCodeForEmail(email)
  then: "We expect send message to the email service"
    thrown AccountNoActivatedException
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
    registrationHelperService.isValidToken(token) >> true
    registrationHelperService.findEmailByToken(token) >> email
    userHelperService.findByEmail(email) >> user
    1 * user.setProperty('password','password')
    1 * user.setProperty('accountLocked', false)
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

  void "should not change password for token since token is expired"(){
  given: "Token and password"
    def token = 'token'
    def password = 'password'
    def email = 'josdem@email.com'
  and: "user"
    def user = Mock(User)
  when: "We send change password for token"
    service.changePasswordForToken(token, password)
  then: "We expect save new password"
    registrationHelperService.isValidToken(token) >> false
    thrown BusinessException
  }

  void "should confirm account for token"(){
  given: "Token and password"
    def token = 'token'
    def email = 'josdem@email.com'
  and: "user"
    def user = Mock(User)
    def profile = new Profile(email:email, firsName:'firsName', motherLastName:'motherLastName', lastName:'lastName')
  when: "We confirm account for token"
    user.enabled >> false
    service.confirmAccountForToken(token)
  then: "We expect user enabled"
    user.profile >> profile
    registrationHelperService.findEmailByToken(token) >> email
    userHelperService.findByEmail(email) >> user
    1 * user.setProperty('enabled',true)
    1 * user.save()
    1 * restService.sendCommand(_ as NameCommand, 'newUserUrl')
  }

  void "should not confirm account for token since user not exist"(){
  given: "Token and password"
    def token = 'token'
    def email = 'josdem@email.com'
  and: "user"
    def user = Mock(User)
  when: "We send change password for token"
    service.confirmAccountForToken(token)
  then: "We expect save new password"
    registrationHelperService.findEmailByToken(token) >> email
    thrown UserNotFoundException
  }

  void "should not confirm account for token since user is already active"(){
  given: "Token and password"
    def token = 'token'
    def email = 'josdem@email.com'
  and: "user"
    def user = Mock(User)
  when: "We send change password for token"
    userHelperService.findByEmail(email) >> user
    user.enabled >> true
    service.confirmAccountForToken(token)
  then: "We expect save new password"
    registrationHelperService.findEmailByToken(token) >> email
    thrown AccountEnabledException
  }

  void "should send a message to recovery an user"(){
  given: "An email"
    def email = 'josdem@email.com'
  and: "And a user"
    def user = Mock(User)
  when: "We send change password for token"
    service.recoveryUser(email)
  then: "We expect save new password"
    user.username >> 'josdem'
    userHelperService.findByEmail(email) >> user
    1 * restService.sendCommand(_ as NameCommand, 'forgotUsernameUrl')
  }

  void "should not send a message to recover user since user not exist"(){
  given: "An email"
    def email = 'josdem@email.com'
  and: "user"
    def user = Mock(User)
  when: "We send change password for token"
    service.recoveryUser(email)
  then: "We expect save new password"
    thrown BusinessException
  }

}
