package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Collaborator)
class CollaboratorSpec extends Specification {

  @Unroll
  void """When we have an collaborator with firstName: #firstName, motherLastName: #motherLastName, lastName: #lastName, position: #position, notes: #notes and we validate we expect result: #result"""() {
  given: "An collaborator"
    Company company = new Company(name:'name',description:'desc')
    Collaborator collaborator = new Collaborator()
    collaborator.company = company
  when: "We assign collaborator values"
    collaborator.firstName = firstName
    collaborator.motherLastName = motherLastName
    collaborator.lastName = lastName
    collaborator.position = position
    collaborator.notes = notes
  then: "We validate collaborator"
    result == collaborator.validate()
  where: "We have next values"
  firstName   | motherLastName   | lastName   | position   | notes   || result
  'firstName' | 'motherLastName' | 'lastName' | 'position' | 'notes' || true
  'firstName' | 'motherLastName' | 'lastName' | 'position' | null    || true
  null        | 'motherLastName' | 'lastName' | 'position' | 'notes' || false
  ''          | 'motherLastName' | 'lastName' | 'position' | 'notes' || false
  'firstName' | null         | 'lastName' | 'position' | 'notes' || false
  'firstName' | ''           | 'lastName' | 'position' | 'notes' || false
  'firstName' | 'motherLastName' | null       | 'position' | 'notes' || false
  'firstName' | 'motherLastName' | ''         | 'position' | 'notes' || false
  'firstName' | 'motherLastName' | 'lastName' | null       | 'notes' || false
  'firstName' | 'motherLastName' | 'lastName' | ''         | 'notes' || false
  'firstName' | 'motherLastName' | 'lastName' | 'position' | ''      || false
  }
}
