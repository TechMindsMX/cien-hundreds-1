package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(LoginService)
class LoginServiceSpec extends Specification {

  void "should send message bad credentials"() {
  given: "An username"
    def username = 'josdem'
  when: "We validate username"
    def result = service.validateUsername(username)
  then: "We expect result"
    result == 'springSecurity.errors.login.fail'
  }

  void "should block account"() {
  given: "An username"
    def username = 'josdem'
  and: "An user"
    def user = Mock(User)
    User.metaClass.static.findByUsername = { josdem -> user }
  when: "We validate username"
    service.validateUsername(username)
    service.validateUsername(username)
    service.validateUsername(username)
    service.validateUsername(username)
    def result = service.validateUsername(username)
  then: "We expect result"
    user.setProperty('countLocked', true)
    1 * user.save(_)
    result == 'springSecurity.errors.login.locked'
  }

  void "should send message locked when more than 5 attemps, but only one modification to user"() {
  given: "An username"
    def username = 'josdem'
  and: "An user"
    def user = Mock(User)
    User.metaClass.static.findByUsername = { josdem -> user }
  when: "We validate username"
    service.validateUsername(username)
    service.validateUsername(username)
    service.validateUsername(username)
    service.validateUsername(username)
    service.validateUsername(username)
    def result = service.validateUsername(username)
  then: "We expect result"
    user.setProperty('countLocked', true)
    1 * user.save(_)
    result == 'springSecurity.errors.login.locked'
  }

  void "should send message bad credentials when no user at 5 attemps"() {
  given: "An username"
    def username = 'josdem'
  and: "An user"
    def user = Mock(User)
    User.metaClass.static.findByUsername = { josdem -> null }
  when: "We validate username"
    service.validateUsername(username)
    service.validateUsername(username)
    service.validateUsername(username)
    service.validateUsername(username)
    def result = service.validateUsername(username)
  then: "We expect result"
    result == 'springSecurity.errors.login.fail'
  }

}
