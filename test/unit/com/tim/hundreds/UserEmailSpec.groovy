package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(UserEmail)
class UserEmailSpec extends Specification {

  @Unroll
  void """When we have an email with: address: #address, type: #type we expect result: #result"""() {
  given: "An email"
    def email = new UserEmail()
  and: "A Contact"
    def user = new User()
    email.user = user
  when: "We assign values"
    email.address = address
    email.type = type
  then: "We validate email"
    result == email.validate()
  where: "We have next values"
  address             | type                || result
  'josdem@email.com'  | EmailType.WORK      || true
  'josdem@email.com'  | EmailType.PERSONAL  || true
  'josdem@email.com'  | EmailType.OTHER     || true
  'josdem@email'      | EmailType.WORK      || false
  'josdememail.com'   | EmailType.WORK      || false
  'josdem@emailcom'   | EmailType.WORK      || false
  }

}
