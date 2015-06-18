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
    and: "A user"
      def user = new User(username:'josdem',password:'password')
      def profile = new Profile(email:'josdem@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
      user.profile = profile
    and: "A Musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = Genre.TRANCE
      musician.hasManager = true
      musician.dateCreated = new Date()
      musician.lastUpdated = new Date()
      musician.formed = new Date()
    and: "We save contact and musician"
      musician.addToContacts(contact)
    and: "We add musician to user"
      user.addToMusicians(musician)
      user.save(flush: true)
    and: "We create an email"
      def emailInstance = new Email(address:'josdem@email.com',type:EmailType.WORK,contact: contact)
    when: "We save email"
      def result = emailService.save(emailInstance)
    then:"We validate command"
      result
    cleanup:"We delete contact"
      user.delete()
  }

  void "Should not save an contact with more than 3 emails"() {
    given: "An contact"
      def contact = new Contact(firstName:'firstName',lastName:'lastName',motherLastName:'motherLastName')
      contact.type = GenderType.MALE
      contact.role = RoleType.MANAGER
      contact.birthDate = new Date()
      contact.entryDate = new Date()
    and: "A user"
      def user = new User(username:'josdem',password:'password')
      def profile = new Profile(email:'josdem@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
      user.profile = profile
    and: "A Musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = Genre.TRANCE
      musician.hasManager = true
      musician.dateCreated = new Date()
      musician.lastUpdated = new Date()
      musician.formed = new Date()
    and: "We save contact and musician"
      musician.addToContacts(contact)
    and: "We add musician to user"
      user.addToMusicians(musician)
      user.save(flush: true)
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
      user.delete()
  }

}
