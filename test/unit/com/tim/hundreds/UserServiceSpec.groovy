package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
class UserServiceSpec extends Specification {
  def userHelperService = Mock(UserHelperService)
  def recoveryService = Mock(RecoveryService)

  def setup() {
    service.userHelperService = userHelperService
    service.recoveryService = recoveryService
  }

  void "should create an user with role type user"() {
  given: "An user and email"
    def user = Mock(User)
    def email = 'josdem@email.com'
  and: "A profile"
    def profile = Mock(Profile)
    profile.email >> email
    user.profile >> profile
    Profile.metaClass.static.findByEmail = { null }
  when: "We assing values to command"
    service.create(user)
  then:"We validate command"
    user.profile >> profile
    1 * user.save()
    1 * userHelperService.addUserRole(user)
    1 * recoveryService.sendConfirmationAccountToken(email)
  }

  void "should not create an user with role type user since user is null"() {
  when: "We assing values to command"
    def result = service.create(null)
  then:"We validate command"
    !result
  }

  void "should not create an user since email is already taken"() {
  given: "An user and email"
    def user = Mock(User)
    def email = 'josdem@email.com'
  and: "A profile"
    def profile = Mock(Profile)
    profile.email >> email
    user.profile >> profile
    Profile.metaClass.static.findByEmail = { user }
  when: "We assing values to command"
    def result = service.create(user)
  then:"We get exception"
    thrown DuplicatedEmailException
  }


}
