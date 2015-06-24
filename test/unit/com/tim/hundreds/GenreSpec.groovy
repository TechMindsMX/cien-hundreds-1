package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Genre)
class GenreSpec extends Specification {

  @Unroll
  void """When we have an genre with this values: #name and we validate we expect result is: #result"""() {
  given: "An Genre"
    def genre = new Genre()
  when: "We assign values following values"
    genre.name = name
  then: "We expect result"
    result == genre.validate()
  where:"We have next values"
  name      || result
  'Trance'  || true
  'A'       || true
  ''        || false
  null      || false
  }
}
