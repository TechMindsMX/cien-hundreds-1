package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MusicianService)
class MusicianServiceSpec extends Specification {
  def validationService = Mock(ValidationService)

  def setup() {
    service.validationService = validationService
  }

  void "should assign musician to facilitator and active musician"() {
  given: "An musician validation"
   def musicianValidationInstance = Mock(MusicianValidation)
  and: "And musician and user"
   def musician = Mock(Musician)
   def user = Mock(User)
   musicianValidationInstance.musician >> musician
   musicianValidationInstance.user >> user
   when: "We assign values to the user"
   service.assignMusicianToFacilitator(musicianValidationInstance)
   then: "We expect musician is save"
   1 * musician.setProperty('assigned', user)
   1 * validationService.validate(musicianValidationInstance, 'musician')
   1 * musician.save()
   1 * musicianValidationInstance.save()
  }

  void "should not filter by date when start date is greater than end date"() {
  given: "A date range"
    def startDate = new Date()
    def endDate = startDate - 9
  when: "We try to get musician by range"
    service.getMusiciansByDateCreated(startDate, endDate)
  then:
    thrown InvalidParamsException
  }

}
