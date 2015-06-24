package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class TagServiceIntegrationSpec extends Specification {
  def tagService

  @Unroll
  void """when we have tags: #tagsComma as String we should add to the musician tags as collection"""() {
  given: "A musician"
    def musician = new Musician(name:'name',history:'history')
    musician.genre = Genre.TRANCE
    musician.hasManager = true
    musician.dateCreated = new Date()
    musician.lastUpdated = new Date()
    musician.formed = new Date()
    musician.save flush: true
  when: "We add tags using service"
    tagService.addMusicianTags(musician, tagsComma)
  then: "We expect following result"
    result == musician.tags.size()
  where: "We have next values"
    tagsComma         || result
    'One, Two'        || 2
    'One'             || 1
    'One,Two'         || 2
    'One,Two,Three'   || 3
    'One,Two,Three,'  || 3
    ',One,Two,Three,' || 3
    'One,Two,null'    || 2
  }

}
