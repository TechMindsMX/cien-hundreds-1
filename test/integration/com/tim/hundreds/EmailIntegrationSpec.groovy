package com.tim.hundreds

import spock.lang.Specification
import grails.validation.ValidationException

class EmailIntegrationSpec extends Specification {
  def emailService

  void "Should save an contact with email"() {
    given: "A musician role"
      def musicianRole = new MusicianRole(name: 'Manager').save()
    and: "An contact"
      def contact = new Contact(firstName:'firstName',lastName:'lastName',motherLastName:'motherLastName')
      contact.type = GenderType.MALE
      contact.role = musicianRole
      contact.birthDate = new Date()
      contact.entryDate = new Date()
    and: "A user"
      def user = new User(username:'emailIntegration1',password:'password')
      def profile = new Profile(email:'emailIntegration1@email.com', firstName:'me', motherLastName:'motherLastName', lastName:'lastName')
      user.profile = profile
    and: "A genre"
      def genre = new Genre(name: 'Trance').save()
    and: "A Musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = genre
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
      def emailInstance = new Email(mail:'josdem@email.com',emailType:EmailType.WORK)
    when: "We save email"
      def result = emailService.save(emailInstance, contact)
    then:"We validate command"
      result
    cleanup:"We delete contact"
      user.delete(flush: true)
  }

  void "Should not save an contact with more than 3 emails"() {
    given: "A musician role"
      def musicianRole = new MusicianRole(name: 'Manager').save()
    and: "An contact"
      def contact = new Contact(firstName:'firstName',lastName:'lastName',motherLastName:'motherLastName')
      contact.type = GenderType.MALE
      contact.role = musicianRole
      contact.birthDate = new Date()
      contact.entryDate = new Date()
    and: "A user"
      def user = new User(username:'emailIntegration2',password:'password')
      def profile = new Profile(email:'emailIntegration2@email.com', firstName:'me', motherLastName:'motherLastName', lastName:'lastName')
      user.profile = profile
    and: "A genre"
      def genre = new Genre(name: 'Trance').save()
    and: "A Musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = genre
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
      def emailInstance1 = new Email(mail:'josdem@email.com',emailType:EmailType.WORK)
      def emailInstance2 = new Email(mail:'josdem@email.com',emailType:EmailType.WORK)
      def emailInstance3 = new Email(mail:'josdem@email.com',emailType:EmailType.WORK)
      def emailInstance4 = new Email(mail:'josdem@email.com',emailType:EmailType.WORK)
    when: "We save emails"
      emailService.save(emailInstance1, contact)
      emailService.save(emailInstance2, contact)
      emailService.save(emailInstance3, contact)
      emailService.save(emailInstance4, contact)
    then:"We expect exception"
      thrown ValidationException
    cleanup:"We delete contact"
      user.delete(flush: true)
  }

}
