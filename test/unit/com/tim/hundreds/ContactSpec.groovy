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
  void """When we have an contact with firstName: #firstName, middleName: #middleName, lastName: #lastName, type: #type and role: #role and we validate, we expect result: #result"""() {
  given: "An contact"
    def contact = new ContactCommand()
  when: "We assign values to command"
    contact.firstName = firstName
    contact.middleName = middleName
    contact.lastName = lastName
    contact.birthDate = birthDate
    contact.entryDate = entryDate
    contact.type = type
    contact.role = role
  then: "We validate command"
    result == contact.validate()
  where: "We have next cases"
  firstName   | middleName   | lastName   | birthDate  | entryDate   | type              | role             || result
  'firstName' | 'middleName' | 'lastName' | new Date() | new Date()  | GenderType.MALE   | RoleType.MANAGER || true
  'f'         | 'middleName' | 'lastName' | new Date() | new Date()  | GenderType.MALE   | RoleType.MANAGER || true
  'firstName' | 'm'          | 'lastName' | new Date() | new Date()  | GenderType.MALE   | RoleType.MANAGER || true
  'firstName' | 'middleName' | 'l'        | new Date() | new Date()  | GenderType.MALE   | RoleType.MANAGER || true
  'firstName' | 'middleName' | 'lastName' | new Date() | new Date()  | GenderType.FEMALE | RoleType.MANAGER || true
  'firstName' | 'middleName' | 'lastName' | new Date() | new Date()  | GenderType.MALE   | RoleType.ELEMENT || true
  'firstName' | 'middleName' | 'lastName' | new Date() | new Date()  | GenderType.MALE   | RoleType.OTHER   || true
  }

  @Unroll
  void """When we have an contact with firstName: #firstName, middleName: #middleName, lastName: #lastName, type: #type and role: #role and we validate, we expect result: #result"""() {
  given: "An contact"
    def contact = new ContactCommand()
  when: "We assign values to command"
    contact.firstName = firstName
    contact.middleName = middleName
    contact.lastName = lastName
    contact.birthDate = birthDate
    contact.entryDate = entryDate
    contact.type = type
    contact.role = role
  then: "We validate command"
    result == contact.validate()
  where: "We have next cases"
  firstName   | middleName   | lastName   | birthDate  | entryDate   | type              | role             || result
  ''          | 'middleName' | 'lastName' | new Date() | new Date()  | GenderType.MALE   | RoleType.MANAGER || false
  null        | 'middleName' | 'lastName' | new Date() | new Date()  | GenderType.MALE   | RoleType.MANAGER || false
  'firstName' | ''           | 'lastName' | new Date() | new Date()  | GenderType.MALE   | RoleType.MANAGER || false
  'firstName' | null         | 'lastName' | new Date() | new Date()  | GenderType.MALE   | RoleType.MANAGER || false
  'firstName' | 'middleName' | ''         | new Date() | new Date()  | GenderType.MALE   | RoleType.MANAGER || false
  'firstName' | 'middleName' | null       | new Date() | new Date()  | GenderType.MALE   | RoleType.MANAGER || false
  'firstName' | 'middleName' | 'lastName' | null       | new Date()  | GenderType.MALE   | RoleType.MANAGER || false
  'firstName' | 'middleName' | 'lastName' | new Date() | null        | GenderType.MALE   | RoleType.MANAGER || false
  'firstName' | 'middleName' | 'lastName' | new Date() | new Date()  | null              | RoleType.MANAGER || false
  'firstName' | 'middleName' | 'lastName' | new Date() | new Date()  | GenderType.MALE   | null             || false
  }

}
