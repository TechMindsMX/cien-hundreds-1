package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

class TagServiceIntegrationSpec extends Specification {
  def tagService

  @Unroll
  void """when we have tags: #tagsComma as String we should add to the musician tags as collection"""() {
  given: "A musician"
    def musician = new Musician(name:'name',history:'history')
    musician.genre = new Genre(name: 'Trance').save()
    musician.hasManager = true
    musician.dateCreated = new Date()
    musician.lastUpdated = new Date()
    musician.formed = new Date()
    musician.save flush: true
  and: "A user"
    def user = new User(username:'tagServiceIntegration',password:'password')
    def profile = new Profile(email:'tagServiceIntegration@email.com', firstName:'me', motherLastName:'motherLastName', lastName:'lastName')
    user.profile = profile
  and: "We add musician to user"
    user.addToMusicians(musician)
    user.save(flush: true)
  when: "We add tags using service"
    tagService.addTags(musician, tagsComma)
  then: "We expect following result"
    result == musician.tags
    println result
  cleanup:"We delete contact"
    user.delete flush: true
  where: "We have next values"
    tagsComma             || result
    'One, Two'            || ['One', 'Two']
    'One'                 || ['One']
    'One,Two'             || ['One', 'Two']
    'One,Two,Three'       || ['One', 'Two', 'Three']
    'One,Two,Three,'      || ['One', 'Two', 'Three']
    ',One,Two,Three,'     || ['One', 'Two', 'Three']
    'One,Two,null'        || ['One', 'Two']
    'One,Two,Three,Three' || ['One', 'Two', 'Three']
  }

}
