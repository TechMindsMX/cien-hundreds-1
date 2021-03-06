package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@url grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Audio)
class AudioSpec extends Specification {

  @Unroll
  void """When we have an audio with url: #url and we validate we expect result is: #result"""() {
  given: "An audio"
    def audio = new Audio()
  and: "A musician"
    def musician = new Musician()
    audio.musician = musician
  when: "We assig values"
    audio.url = url
  then: "We validate data"
    result == audio.validate()
  where: "The following data"
  url                                                         || result
  'https://soundcloud.com/fettywap1738-zoo/fetty-wap-again'   || true
  'https://soundcloud.com/reyhan-rizky-1/sets/ghost-bc'       || true
  'https://probando12.com/aboveandbeyond/abgt100'             || false
  'h'                                                         || false
  ''                                                          || false
  null                                                        || false
  }

}
