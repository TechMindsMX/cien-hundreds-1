package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ValidationService)
class ValidationServiceSpec extends Specification {
  def restService = Mock(RestService)

  def setup() {
    service.restService = restService
    grailsApplication.config.facilitator.assigned.url = 'facilitatorAssignedUrl'
    grailsApplication.config.musician.refused.url = 'musicianRefusedUrl'
  }

  void "should validate an musician"() {
  given: "An musician validation"
    def musicianValidation = Mock(MusicianValidation)
  and: "Musician, user and profile"
    def facilitator = Mock(User)
    def musician = Mock(Musician)
    def profile = Mock(Profile)
  when: "We validate musician"
    musicianValidation.type >> ValidationType.ACCEPTED
    musicianValidation.user >> facilitator
    musicianValidation.musician >> musician
    facilitator.profile >> profile
    service.validate(musicianValidation)
  then: "We expect musician validated"
    1 * musician.setProperty('active', true)
    1 * restService.sendCommand(_ as FacilitatorCommand, 'facilitatorAssignedUrl')
  }

  void "should refuse an musician"() {
  given: "An musician validation"
    def musicianValidation = Mock(MusicianValidation)
  and: "Musician, user and profile"
    def user = Mock(User)
    def musician = Mock(Musician)
    def profile = Mock(Profile)
  when: "We validate musician"
    musicianValidation.type >> ValidationType.REFUSED
    musicianValidation.musician >> musician
    musician.user >> user
    user.profile >> profile
    service.validate(musicianValidation)
  then: "We expect musician validated"
    1 * musician.setProperty('active', false)
    1 * restService.sendCommand(_ as FacilitatorCommand, 'musicianRefusedUrl')
  }


}
