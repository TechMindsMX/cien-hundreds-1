package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Video)
class VideoSpec extends Specification {

  @Unroll
  void """When we have a video with url: #url and we validate we are expecting result is: #result"""() {
  given: "An video"
    def video = new Video()
  and: "An musician"
    def musician = new Musician()
    video.musician = musician
  when: "We assign values"
    video.url = url
  then: "We validate result"
    result == video.validate()
  where: "We have next values"
  url                             || result
  'https://youtu.be/LKckM5gq7VU'  || true
  'h'                             || false
  ''                              || false
  null                            || false
  }

}
