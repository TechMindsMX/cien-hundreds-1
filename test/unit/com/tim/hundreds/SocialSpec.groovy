package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Social)
class SocialSpec extends Specification {

  void "When we have a social with: facebook: #facebook, twitter: #twitter, googlePlus: #googlePlus, instagram: #instagram, youtube: #youtube, linkedin: #linkedin, other: #other and when we validate we expect the result is: #result"() {
  given: "And Social"
    Social social = new Social()
  when: "We assign values to the social"
    social.facebook = facebook
    social.twitter = twitter
    social.googlePlus = googlePlus
    social.instagram = instagram
    social.youtube = youtube
    social.linkedin = linkedin
    social.other = other
  then: "We validate social"
    result == social.validate()
  where: "We have next cases"
  facebook | twitter | googlePlus | instagram | youtube | linkedin | other || result
  }

}
