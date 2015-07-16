package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

class ActivityServiceIntegrationSpec extends Specification {
  def activityService

  void "Should save an musician with activity"() {
    given: "An Genre"
      def genre = new Genre(name:'Trance').save()
    and: "An musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = genre
      musician.hasManager = true
      musician.dateCreated = new Date()
      musician.lastUpdated = new Date()
      musician.formed = new Date()
    and: "A user"
      def user = new User(username:'activityService',password:'password')
      def profile = new Profile(email:'activityService@email.com', firstName:'me', motherLastName:'motherLastName', lastName:'lastName')
      user.profile = profile
    and: "We add musician to user"
      user.addToMusicians(musician)
      user.save(flush: true)
      musician.validate()
      println musician.dump()
    and: "We create an activity"
      def activityInstance = new Activity(activity:'activity', place:'place',date:new Date())
      activityInstance.musician = musician
    when: "We save activity"
      def result = activityService.save(activityInstance)
    then:"We validate activity"
      result
      1 == musician.activities.size()
    cleanup:"We delete user"
      user.delete(flush: true)
  }
}
