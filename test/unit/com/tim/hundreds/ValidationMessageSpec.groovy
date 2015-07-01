package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll


@TestFor(ValidationMessage)
class ValidationMessageSpec extends Specification {

  @Unroll
  void """When we have an validation message with message: #message and we validate data we expect result is: #result"""() {
  given: "An validation message"
    def validationMessage = new ValidationMessage()
  and: "A user and musician"
    def user = new User()
    def musician = new Musician()
  and: "We assign user and musician"
    validationMessage.user = user
    validationMessage.musician = musician
  when: "We assign values"
    validationMessage.message = message
  then: "We validate"
    result == validationMessage.validate()
  where:"We have next values"
    message     || result
    'message'   || true
    'm'         || true
    null        || false
    ''          || false
  }

}
