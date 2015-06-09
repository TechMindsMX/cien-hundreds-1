package com.tim.hundreds

import spock.lang.Specification
import grails.validation.ValidationException

/**
 *
 */
class TelephoneIntegrationSpec extends Specification {
  def telephoneService

  void "Should save an contact with telephone"() {
    given: "An contact"
      def contact = new Contact(firstName:'firstName',middleName:'middleName',lastName:'lastName')
      contact.type = GenderType.MALE
      contact.role = RoleType.MANAGER
      contact.birthDate = new Date()
      contact.entryDate = new Date()
    and: "A Musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = Genre.TRANCE
      musician.hasManager = true
      musician.dateCreated = new Date()
      musician.lastUpdated = new Date()
      musician.formed = new Date()
    and: "We save contact and musician"
      musician.save(flush: true)
      contact.musician = musician
      contact.save(flush: true)
    and: "We create an telephone"
      def telephonecontact = new Telephone(phone:'1234567890',type:TelephoneType.WORK)
    when: "We save telephone"
      def result = telephoneService.save(telephonecontact, contact)
    then:"We validate command"
      result
    cleanup:"We delete contact"
      musician.delete()
  }

  void "Should not save an contact with more than 3 telephones"() {
    given: "An contact"
      def contact = new Contact(firstName:'firstName',middleName:'middleName',lastName:'lastName')
      contact.type = GenderType.MALE
      contact.role = RoleType.MANAGER
      contact.birthDate = new Date()
      contact.entryDate = new Date()
    and: "A Musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = Genre.TRANCE
      musician.hasManager = true
      musician.dateCreated = new Date()
      musician.lastUpdated = new Date()
      musician.formed = new Date()
    and: "We save contact and musician"
      musician.save(flush: true)
      contact.musician = musician
      contact.save(flush: true)
    and: "We create an telephone"
      def telephonecontact1 = new Telephone(phone:'1234567890',type:TelephoneType.WORK)
      def telephonecontact2 = new Telephone(phone:'1234567890',type:TelephoneType.WORK)
      def telephonecontact3 = new Telephone(phone:'1234567890',type:TelephoneType.WORK)
      def telephonecontact4 = new Telephone(phone:'1234567890',type:TelephoneType.WORK)
    when: "We save telephone"
      telephoneService.save(telephonecontact1, contact)
      telephoneService.save(telephonecontact2, contact)
      telephoneService.save(telephonecontact3, contact)
      telephoneService.save(telephonecontact4, contact)
    then:"We expect exception"
      thrown ValidationException
    cleanup:"We delete contact"
      musician.delete()
  }

}
