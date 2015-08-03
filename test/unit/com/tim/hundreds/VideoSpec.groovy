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
  url                                           || result
  'https://youtu.be/c9_9y9zBRVQ'                || true
  'https://youtu.be/LKckM5gq7VU'                || true
  'https://www.youtube.com/watch?v=4R3CZeHaD_4' || true
  'https://vimeo.com/130593856'                 || true
  'https://yoitube.com/83742834'                || false
  'https://probando12.com/abovea'               || false
  'h'                                           || false
  ''                                            || false
  null                                          || false
  }

}
