package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(RegistrationCode)
class RegistrationCodeSpec extends Specification {

  @Unroll
  void """When we have registration code with timestamp: #timestamp and we validate we expect result: #result"""() {
  given: "Registration code"
    def registrationCode = new RegistrationCode()
  when: "We assign values"
    registrationCode.timestamp = timestamp
  then: "We validate result"
    result == registrationCode.isValid()
  where: "We have next values"
  timestamp                              || result
  new Date().getTime() - 1000 * 60 * 1   || true
  new Date().getTime() - 1000 * 60 * 2   || true
  new Date().getTime() - 1000 * 60 * 3   || true
  new Date().getTime() - 1000 * 60 * 4   || true
  new Date().getTime() - 1000 * 60 * 5   || true
  new Date().getTime() - 1000 * 60 * 6   || true
  new Date().getTime() - 1000 * 60 * 7   || true
  new Date().getTime() - 1000 * 60 * 8   || true
  new Date().getTime() - 1000 * 60 * 9   || true
  new Date().getTime() - 1000 * 60 * 10  || true
  new Date().getTime() - 1000 * 60 * 11  || true
  new Date().getTime() - 1000 * 60 * 12  || true
  new Date().getTime() - 1000 * 60 * 13  || true
  new Date().getTime() - 1000 * 60 * 14  || true
  new Date().getTime() - 1000 * 60 * 15  || true
  new Date().getTime() - 1000 * 60 * 16  || true
  new Date().getTime() - 1000 * 60 * 17  || true
  new Date().getTime() - 1000 * 60 * 18  || true
  new Date().getTime() - 1000 * 60 * 19  || true
  new Date().getTime() - 1000 * 60 * 20  || false
  new Date().getTime() - 1000 * 60 * 21  || false
  new Date().getTime() - 1000 * 60 * 22  || false
  new Date().getTime() - 1000 * 60 * 30  || false
  }

}
