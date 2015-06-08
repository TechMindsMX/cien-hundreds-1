package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
class UserServiceSpec extends Specification {
  UserHelperService userHelperService = Mock(UserHelperService)

  def setup() {
    service.userHelperService = userHelperService
  }

  void "should create an user with role type user"() {
  given: "An user"
    User user = Mock(User)
  when: "We assing values to command"
    service.create(user)
  then:"We validate command"
    1 * userHelperService.addUserRole(user)
  }

  void "should not create an user with role type user since user is null"() {
  when: "We assing values to command"
    def result = service.create(null)
  then:"We validate command"
    !result
  }

}
