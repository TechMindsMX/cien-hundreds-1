package com.tim.hundreds

import spock.lang.Specification
import grails.validation.ValidationException

/**
 *
 */
class EmailIntegrationSpec extends Specification {
  def emailService

  void "Should save an contact with email"() {
    given: "An contact"
      def contact = new Contact(firstName:'firstName',lastName:'lastName',motherLastName:'motherLastName')
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
    and: "We create an email"
      def emailInstance = new Email(address:'josdem@email.com',type:EmailType.WORK,contact: contact)
    when: "We save email"
      def result = emailService.save(emailInstance)
    then:"We validate command"
      result
    cleanup:"We delete contact"
      musician.delete()
  }

  void "Should not save an contact with more than 3 emails"() {
    given: "An contact"
      def contact = new Contact(firstName:'firstName',lastName:'lastName',motherLastName:'motherLastName')
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
    and: "We create several emails"
      def emailInstance1 = new Email(address:'josdem@email.com',type:EmailType.WORK,contact: contact)
      def emailInstance2 = new Email(address:'josdem@email.com',type:EmailType.WORK,contact: contact)
      def emailInstance3 = new Email(address:'josdem@email.com',type:EmailType.WORK,contact: contact)
      def emailInstance4 = new Email(address:'josdem@email.com',type:EmailType.WORK,contact: contact)
    when: "We save emails"
      emailService.save(emailInstance1)
      emailService.save(emailInstance2)
      emailService.save(emailInstance3)
      emailService.save(emailInstance4)
    then:"We expect exception"
      thrown ValidationException
    cleanup:"We delete contact"
      musician.delete()
  }

}
