package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Photo)
class PhotoSpec extends Specification {

  @Unroll
  void """When we have an photo with path: #path we expect result: #result"""() {
  given: "A photo"
    def photo = new Photo()
  and: "A musician"
    def musician = new Musician()
    photo.musician = musician
  when: "We assign values"
    photo.path = path
  then: "We validate result"
    result == photo.validate()
  where: "We have next values"
  path                                    || result
  '5c7f5fdfd9a34af3abb28302efb45996.png'  || true
  '5c7f5fdfd9a34af3abb28302efb45996.pn'   || false
  '5c7f5fdfd9a34af3abb28302efb45996.pnge' || false
  '5c7f5fdfd9a34af3abb28302efb45996'      || false
  '5'                                     || false
  ''                                      || false
  null                                    || false
  }
}
