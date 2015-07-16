package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(ValidationService)
class ValidationServiceSpec extends Specification {
  def restService = Mock(RestService)

  def setup() {
    service.restService = restService
    grailsApplication.config.musician.assigned.target.url = 'facilitatorAssignedUrl'
    grailsApplication.config.musician.refused.url = 'musicianRefusedUrl'
  }

  void "should validate an musician"() {
  given: "An musician validation"
    def musicianValidation = Mock(MusicianValidation)
  and: "Musician, user and profile"
    def facilitator = Mock(User)
    def user = Mock(User)
    def musician = Mock(Musician)
    def facilitatorProfile = Mock(Profile)
    def userProfile = Mock(Profile)
  when: "We validate musician"
    musicianValidation.type >> ValidationType.ACCEPTED
    musicianValidation.user >> facilitator
    musicianValidation.musician >> musician
    musician.user >> user
    facilitator.profile >> facilitatoProfile
    user.profile >> userProfile
    service.validate(musicianValidation, 'musician')
  then: "We expect musician validated"
    1 * musician.setProperty('active', true)
    1 * restService.sendCommand(_ as AssignationCommand, 'facilitatorAssignedUrl')
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
    service.validate(musicianValidation, 'musician')
  then: "We expect musician validated"
    1 * musician.setProperty('active', false)
    1 * restService.sendCommand(_ as AssignationCommand, 'musicianRefusedUrl')
  }

}
