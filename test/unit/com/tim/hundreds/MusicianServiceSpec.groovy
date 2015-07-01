package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(MusicianService)
class MusicianServiceSpec extends Specification {

    def setup() {
    }

  void "should save an musician"() {
  given: "An user"
   def user = new User()
  and: "And musician"
  }
}
