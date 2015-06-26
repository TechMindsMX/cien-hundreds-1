package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Contact)
class ContactSpec extends Specification {

  @Unroll
  void """When we have an contact with firstName: #firstName, motherLastName: #motherLastName, lastName: #lastName, type: #type and role: #role and we validate, we expect result: #result"""() {
  given: "An contact"
    def contact = new ContactCommand()
  when: "We assign values to command"
    contact.firstName = firstName
    contact.motherLastName = motherLastName
    contact.lastName = lastName
    contact.birthDate = birthDate
    contact.entryDate = entryDate
    contact.type = type
    contact.role = role
  then: "We validate command"
    result == contact.validate()
  where: "We have next cases"
  firstName   | motherLastName   | lastName   | birthDate  | entryDate   | type              | role                              || result
  'firstName' | 'motherLastName' | 'lastName' | new Date() | new Date()  | GenderType.MALE   | new MusicianRole(name: 'Manager') || true
  'f'         | 'motherLastName' | 'lastName' | new Date() | new Date()  | GenderType.MALE   | new MusicianRole(name: 'Manager') || true
  'firstName' | 'm'              | 'lastName' | new Date() | new Date()  | GenderType.MALE   | new MusicianRole(name: 'Manager') || true
  'firstName' | 'motherLastName' | 'l'        | new Date() | new Date()  | GenderType.MALE   | new MusicianRole(name: 'Manager') || true
  'firstName' | 'motherLastName' | 'lastName' | new Date() | new Date()  | GenderType.FEMALE | new MusicianRole(name: 'Manager') || true
  'firstName' | 'motherLastName' | 'lastName' | new Date() | new Date()  | GenderType.MALE   | new MusicianRole(name: 'Element') || true
  'firstName' | 'motherLastName' | 'lastName' | new Date() | new Date()  | GenderType.MALE   | new MusicianRole(name: 'Other')   || true
  }

  @Unroll
  void """When we have an contact with firstName: #firstName, motherLastName: #motherLastName, lastName: #lastName, type: #type and role: #role and we validate, we expect result: #result"""() {
  given: "An contact"
    def contact = new ContactCommand()
  when: "We assign values to command"
    contact.firstName = firstName
    contact.motherLastName = motherLastName
    contact.lastName = lastName
    contact.birthDate = birthDate
    contact.entryDate = entryDate
    contact.type = type
    contact.role = role
  then: "We validate command"
    result == contact.validate()
  where: "We have next cases"
  firstName   | motherLastName   | lastName   | birthDate  | entryDate   | type              | role                              || result
  ''          | 'motherLastName' | 'lastName' | new Date() | new Date()  | GenderType.MALE   | new MusicianRole(name: 'Manager') || false
  null        | 'motherLastName' | 'lastName' | new Date() | new Date()  | GenderType.MALE   | new MusicianRole(name: 'Manager') || false
  'firstName' | ''               | 'lastName' | new Date() | new Date()  | GenderType.MALE   | new MusicianRole(name: 'Manager') || false
  'firstName' | null             | 'lastName' | new Date() | new Date()  | GenderType.MALE   | new MusicianRole(name: 'Manager') || false
  'firstName' | 'motherLastName' | ''         | new Date() | new Date()  | GenderType.MALE   | new MusicianRole(name: 'Manager') || false
  'firstName' | 'motherLastName' | null       | new Date() | new Date()  | GenderType.MALE   | new MusicianRole(name: 'Manager') || false
  'firstName' | 'motherLastName' | 'lastName' | null       | new Date()  | GenderType.MALE   | new MusicianRole(name: 'Manager') || false
  'firstName' | 'motherLastName' | 'lastName' | new Date() | null        | GenderType.MALE   | new MusicianRole(name: 'Manager') || false
  'firstName' | 'motherLastName' | 'lastName' | new Date() | new Date()  | null              | new MusicianRole(name: 'Manager') || false
  'firstName' | 'motherLastName' | 'lastName' | new Date() | new Date()  | GenderType.MALE   | null                              || false
  }

}
