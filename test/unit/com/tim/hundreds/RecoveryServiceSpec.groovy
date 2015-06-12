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

  def setup() {
    service.restService = restService
    service.userHelperService = userHelperService
    service.recoveryCollaboratorService = recoveryCollaboratorService
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
}
