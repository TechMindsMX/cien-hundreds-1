package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
class UserControllerSpec extends Specification {
  UserService userService = Mock(UserService)

  def setup() {
    controller.userService = userService
  }

  void "should create user"() {
  given:
    def user = new User()
    user.username = "josdem"
    user.password = "password"
  when:
    controller.create(user)
  then:
    1 * userService.create(user)
  }
}
