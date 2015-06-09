package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Activity)
class ActivitySpec extends Specification {

  void """When we have an activity with: activity: #activity, place: #place, date: #date and we want to validate we expect result is: #result"""() {
  given: "An activity"
    def activityInstance = new Activity()
  and: "A musician"
    def musician = new Musician()
    activityInstance.musician = musician
  when: "We populate data"
    activityInstance.activity = activity
    activityInstance.place = place
    activityInstance.date = date
  then: "We validate data"
    result == activityInstance.validate()
  where: "We have following values"
  activity   | place   | date       || result
  'activity' | 'place' | new Date() || true
  'a'        | 'place' | new Date() || true
  'activity' | 'p'     | new Date() || true
  ''         | 'place' | new Date() || false
  'activity' | ''      | new Date() || false
  null       | 'place' | new Date() || false
  'activity' | null    | new Date() || false
  'activity' | 'place' | null       || false
  }

}
