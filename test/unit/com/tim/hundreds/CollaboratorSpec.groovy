package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Collaborator)
class CollaboratorSpec extends Specification {

<<<<<<< HEAD
  @Unroll
  void """When we have an collaborator with firstName: #firstName, middleName: #middleName, lastName: #lastName, position: #position, notes: #notes and we validate we expect result: #result"""() {
  given: "An collaborator"
    Company company = new Company(name:'name',description:'desc')
    Collaborator collaborator = new Collaborator()
    collaborator.company = company
  when: "We assign collaborator values"
    collaborator.firstName = firstName
    collaborator.middleName = middleName
    collaborator.lastName = lastName
    collaborator.position = position
    collaborator.notes = notes
  then: "We validate collaborator"
    result == collaborator.validate()
  where: "We have next values"
  firstName   | middleName   | lastName   | position   | notes   || result
  'firstName' | 'middleName' | 'lastName' | 'position' | 'notes' || true
  'firstName' | 'middleName' | 'lastName' | 'position' | null    || true
  null        | 'middleName' | 'lastName' | 'position' | 'notes' || false
  ''          | 'middleName' | 'lastName' | 'position' | 'notes' || false
  'firstName' | null         | 'lastName' | 'position' | 'notes' || false
  'firstName' | ''           | 'lastName' | 'position' | 'notes' || false
  'firstName' | 'middleName' | null       | 'position' | 'notes' || false
  'firstName' | 'middleName' | ''         | 'position' | 'notes' || false
  'firstName' | 'middleName' | 'lastName' | null       | 'notes' || false
  'firstName' | 'middleName' | 'lastName' | ''         | 'notes' || false
  'firstName' | 'middleName' | 'lastName' | 'position' | ''      || false
  }
}
