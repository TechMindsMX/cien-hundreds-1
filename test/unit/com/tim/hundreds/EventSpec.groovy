package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Event)
class EventSpec extends Specification {

  @Unroll
  void """When we have an event with activity: #activity, place: #place, date: #date we expect result is: #result"""() {
  given: "A Event"
    def event = new Event()
  and: "A company"
    def company = new Company()
    event.company = company
  when: "We assign values"
    event.activity = activity
    event.place = place
    event.date = date
  then: "We validate value"
    result == event.validate()
  where: "We have next values"
  activity   | place   | date       || result
  'activity' | 'place' | new Date() || true
  'a'        | 'place' | new Date() || true
  'activity' | 'p'     | new Date() || true
  ''         | 'place' | new Date() || false
  null       | 'place' | new Date() || false
  'activity' | ''      | new Date() || false
  'activity' | null    | new Date() || false
  'activity' | 'place' | null       || false
  }
}
