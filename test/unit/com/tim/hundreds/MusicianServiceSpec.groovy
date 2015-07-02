package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(MusicianService)
class MusicianServiceSpec extends Specification {

  void "should assign musician to facilitator and active musician"() {
  given: "An musician validation"
   def musicianValidationInstance = Mock(MusicianValidation)
  and: "And musician and user"
   def musician = Mock(Musician)
   def user = Mock(User)
   musicianValidationInstance.musician >> musician
   musicianValidationInstance.user >> user
   musicianValidationInstance.type >> ValidationType.ACCEPTED
   when: "We assign values to the user"
   service.assignMusicianToFacilitator(musicianValidationInstance)
   then: "We expect musician is save"
   1 * musician.setProperty('assigned', user)
   1 * musician.setProperty('active', true)
   1 * musician.save()
   1 * musicianValidationInstance.save()
  }

  void "should assign musician to facilitator and reject musician"() {
  given: "An musician validation"
   def musicianValidationInstance = Mock(MusicianValidation)
  and: "And musician and user"
   def musician = Mock(Musician)
   def user = Mock(User)
   musicianValidationInstance.musician >> musician
   musicianValidationInstance.user >> user
   musicianValidationInstance.type >> ValidationType.REJECTED
   when: "We assign values to the user"
   service.assignMusicianToFacilitator(musicianValidationInstance)
   then: "We expect musician is save"
   1 * musician.setProperty('assigned', user)
   1 * musician.setProperty('active', false)
   1 * musician.save()
   1 * musicianValidationInstance.save()
  }

}
