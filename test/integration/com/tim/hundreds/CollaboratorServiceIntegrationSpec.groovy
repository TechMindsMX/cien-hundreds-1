package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

class CollaboratorServiceIntegrationSpec extends Specification {
  def collaboratorService

  void "should save an email"() {
  given: "An collaborator"
    def collaborator = new Collaborator(firstName: 'firstName', middleName: 'middleName', lastName: 'lastName', position: 'position')
  and: "An email"
    def email = new Email(address: 'josdem@email.com', EmailType.PERSONAL)
  when: "We save an email"
     assert collaborator.emails.isEmpty()
     result = collaboratorService.saveEmail(collaborator, email)
  then: "We expect"
     1 == result.emails.size()
     result
  }

  void "should save an telephone"() {
  given: "An collaborator"
    def collaborator = new Collaborator(firstName: 'firstName', middleName: 'middleName', lastName: 'lastName', position: 'position')
  and: "An telephone"
    def telephone = new Telephone(phone: '5512345678', TelephoneType.WORK)
  when: "We save an email"
     assert collaborator.telephones.isEmpty()
     result = collaboratorService.saveTelephone(collaborator, email)
  then: "We expect"
     1 == result.emails.size()
     result
  }

}
