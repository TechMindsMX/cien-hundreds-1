package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(MusicianValidation)
class MusicianValidationSpec extends Specification {

  @Unroll
  void """When we have an validation message with message: #message and we validate data we expect result is: #result"""() {
    given: "An validation message"
      def musicianValidation = new MusicianValidation()
    and: "A user and musician"
      def user = new User()
      def musician = new Musician()
    and: "We assign user and musician"
      musicianValidation.user = user
      musicianValidation.musician = musician
    when: "We assign values"
      musicianValidation.message = message
      musicianValidation.type = type
    then: "We validate"
      result == musicianValidation.validate()
    where:"We have next values"
      message   | type || result
    'message'   | ValidationType.ACCEPTED     || true
    'message'   | ValidationType.REFUSED      || true
    'm'         | ValidationType.ACCEPTED     || true
    null        | ValidationType.ACCEPTED     || true
    ''          | ValidationType.ACCEPTED     || false
    'message'   | null                        || false
  }

}
