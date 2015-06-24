package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

class ActivityServiceIntegrationSpec extends Specification {
  def activityService

  void "Should save an musician with activity"() {
    given: "An musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = GenreType.TRANCE
      musician.hasManager = true
      musician.dateCreated = new Date()
      musician.lastUpdated = new Date()
      musician.formed = new Date()
    and: "A user"
      def user = new User(username:'josdem',password:'password')
      def profile = new Profile(email:'josdem@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
      user.profile = profile
      user.save(flush: true)
    and: "We add musician to user"
      user.addToMusicians(musician)
      user.save()
    and: "We create an activity"
      def activityInstance = new Activity(activity:'activity', place:'place',date:new Date())
      activityInstance.musician = musician
    when: "We save activity"
      def result = activityService.save(activityInstance)
    then:"We validate activity"
      result
      1 == musician.activities.size()
    cleanup:"We delete user"
      user.delete()
  }
}
