package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Social)
class SocialSpec extends Specification {

  @Unroll
  void "When we have a social with: facebook: #facebook, twitter: #twitter, googlePlus: #googlePlus, instagram: #instagram, youtube: #youtube, linkedin: #linkedin, other: #other,  and when we validate we expect the result is: #result"() {
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

    social.musician = musicianId
    social.company = companyId
    social.contact = contactId
  then: "We validate social"
    result == social.validate()
  where: "We have next cases"
  facebook                                  | twitter                               | googlePlus                                | instagram                              | youtube                                         | linkedin                                          | other                    | musicianId     | companyId     | contactId     || result
  'https://www.facebook.com/aboveandbeyond' | 'https://twitter.com/aboveandbeyond'  | 'https://plus.google.com/+aboveandbeyond' | 'https://instagram.com/aboveandbeyond' | 'https://www.youtube.com/user/aboveandbeyondtv' | 'https://www.linkedin.com/company/above-&-beyond' | 'https://www.other.com/' | new Musician() | null          | null          || true
  'https://www.facebook.com/aboveandbeyond' | 'https://twitter.com/aboveandbeyond'  | 'https://plus.google.com/+aboveandbeyond' | 'https://instagram.com/aboveandbeyond' | 'https://www.youtube.com/user/aboveandbeyondtv' | 'https://www.linkedin.com/company/above-&-beyond' | 'https://www.other.com/' | null           | new Company() | null          || true
  'https://www.facebook.com/aboveandbeyond' | 'https://twitter.com/aboveandbeyond'  | 'https://plus.google.com/+aboveandbeyond' | 'https://instagram.com/aboveandbeyond' | 'https://www.youtube.com/user/aboveandbeyondtv' | 'https://www.linkedin.com/company/above-&-beyond' | 'https://www.other.com/' | null           | null          | new Contact() || true
  ''                                        | 'https://twitter.com/aboveandbeyond'  | 'https://plus.google.com/+aboveandbeyond' | 'https://instagram.com/aboveandbeyond' | 'https://www.youtube.com/user/aboveandbeyondtv' | 'https://www.linkedin.com/company/above-&-beyond' | 'https://www.other.com/' | new Musician() | null          | null          || false
  'https://www.facebook.com/aboveandbeyond' | ''                                    | 'https://plus.google.com/+aboveandbeyond' | 'https://instagram.com/aboveandbeyond' | 'https://www.youtube.com/user/aboveandbeyondtv' | 'https://www.linkedin.com/company/above-&-beyond' | 'https://www.other.com/' | new Musician() | null          | null          || false
  'https://www.facebook.com/aboveandbeyond' | 'https://twitter.com/aboveandbeyond'  | ''                                        | 'https://instagram.com/aboveandbeyond' | 'https://www.youtube.com/user/aboveandbeyondtv' | 'https://www.linkedin.com/company/above-&-beyond' | 'https://www.other.com/' | new Musician() | null          | null          || false
  'https://www.facebook.com/aboveandbeyond' | 'https://twitter.com/aboveandbeyond'  | 'https://plus.google.com/+aboveandbeyond' | ''                                     | 'https://www.youtube.com/user/aboveandbeyondtv' | 'https://www.linkedin.com/company/above-&-beyond' | 'https://www.other.com/' | new Musician() | null          | null          || false
  'https://www.facebook.com/aboveandbeyond' | 'https://twitter.com/aboveandbeyond'  | 'https://plus.google.com/+aboveandbeyond' | 'https://instagram.com/aboveandbeyond' | ''                                              | 'https://www.linkedin.com/company/above-&-beyond' | 'https://www.other.com/' | new Musician() | null          | null          || false
  'https://www.facebook.com/aboveandbeyond' | 'https://twitter.com/aboveandbeyond'  | 'https://plus.google.com/+aboveandbeyond' | 'https://instagram.com/aboveandbeyond' | 'https://www.youtube.com/user/aboveandbeyondtv' | ''                             | 'https://www.other.com/'                    | new Musician() | null          | null          || false
  'https://www.facebook.com/aboveandbeyond' | 'https://twitter.com/aboveandbeyond'  | 'https://plus.google.com/+aboveandbeyond' | 'https://instagram.com/aboveandbeyond' | 'https://www.youtube.com/user/aboveandbeyondtv' | 'https://www.linkedin.com/company/above-&-beyond' | ''                       | new Musician() | null          | null          || false
  }
}
