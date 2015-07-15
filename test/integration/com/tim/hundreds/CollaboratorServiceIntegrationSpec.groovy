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
     result = collaboratorService.saveEmail(collaborator, email)
  then: "We expect"
     1 == result.emails.size()
     result
  }
}
