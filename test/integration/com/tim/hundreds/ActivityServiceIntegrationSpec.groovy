package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

class ActivityServiceIntegrationSpec extends Specification {
  def activityService

  void "Should save an musician with activity"() {
    given: "An musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = Genre.TRANCE
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
    and: "We create an audio"
      def activityInstance = new Activity(activity:'activity', place:'place',date:new Date())
      activityInstance.musician = musician
    when: "We save audio"
      def result = activityService.save(activityInstance)
    then:"We validate audio"
      result
      1 == musician.activities.size()
    cleanup:"We delete musician"
      user.delete()
  }
}
