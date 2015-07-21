package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.validation.ValidationException

class ContactServiceIntegrationSpec extends Specification {
  def contactService

  void "should save an email"() {
  given: "An contact"
    def contact = new Contact(firstName:'firstName',lastName:'lastName',motherLastName:'motherLastName')
    contact.type = GenderType.MALE
    contact.role = new MusicianRole(name: 'Manager').save()
    contact.birthDate = new Date()
    contact.entryDate = new Date()
  and: "A user"
    def user = new User(username:'contactServiceIntegration1',password:'password')
    def profile = new Profile(email:'contactServiceIntegration1@email.com', firstName:'me', motherLastName:'motherLastName', lastName:'lastName')
    user.profile = profile
  and: "A Musician"
    def musician = new Musician(name:'name',history:'history')
    musician.genre = new Genre(name: 'Trance').save()
    musician.hasManager = true
    musician.dateCreated = new Date()
    musician.lastUpdated = new Date()
    musician.formed = new Date()
  and: "We save contact and musician"
    musician.addToContacts(contact)
  and: "We add musician to user"
    user.addToMusicians(musician)
    user.save(flush: true)
  and: "An email"
    def email = new Email(mail: 'josdem@email.com', emailType: EmailType.PERSONAL)
  when: "We save an email"
    def result = contactService.saveEmail(contact, email)
  then: "We expect"
     1 == result.emails.size()
     result
  cleanup:"We delete contact"
    user.delete(flush: true)

  }

  void "should save an telephone"() {
  given: "An contact"
    def contact = new Contact(firstName:'firstName',lastName:'lastName',motherLastName:'motherLastName')
    contact.type = GenderType.MALE
    contact.role = new MusicianRole(name: 'Manager').save()
    contact.birthDate = new Date()
    contact.entryDate = new Date()
  and: "A user"
    def user = new User(username:'contactServiceIntegration2',password:'password')
    def profile = new Profile(email:'contactServiceIntegration2@email.com', firstName:'me', motherLastName:'motherLastName', lastName:'lastName')
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
  and: "An telephone"
    def telephone = new Telephone(phone: '5512345678', phoneType: TelephoneType.WORK)
  when: "We save an email"
    def result = contactService.saveTelephone(contact, telephone)
  then: "We expect"
     1 == result.telephones.size()
     result
  cleanup:"We delete contact"
      user.delete(flush: true)

  }

  void "Should not save an contact with more than 3 emails"() {
    given: "An contact"
      def contact = new Contact(firstName:'firstName',lastName:'lastName',motherLastName:'motherLastName')
      contact.type = GenderType.MALE
      contact.role = new MusicianRole(name: 'Manager').save()
      contact.birthDate = new Date()
      contact.entryDate = new Date()
    and: "A user"
      def user = new User(username:'contactServiceIntegration3',password:'password')
      def profile = new Profile(email:'contactServiceIntegration3@email.com', firstName:'me', motherLastName:'motherLastName', lastName:'lastName')
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
      contactService.saveEmail(contact, emailInstance1)
      contactService.saveEmail(contact, emailInstance2)
      contactService.saveEmail(contact, emailInstance3)
      contactService.saveEmail(contact, emailInstance4)
    then:"We expect exception"
      thrown ValidationException
    cleanup:"We delete contact"
      user.delete(flush: true)
  }

  void "Should not save an contact with more than 3 telephones"() {
    given: "An contact"
      def contact = new Contact(firstName:'firstName',lastName:'lastName',motherLastName:'motherLastName')
      contact.type = GenderType.MALE
      contact.role = new MusicianRole(name: 'Manager').save()
      contact.birthDate = new Date()
      contact.entryDate = new Date()
    and: "A user"
      def user = new User(username:'contactServiceIntegration4',password:'password')
      def profile = new Profile(email:'contactServiceIntegration4@email.com', firstName:'me', motherLastName:'motherLastName', lastName:'lastName')
      user.profile = profile
    and: "A Musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = new Genre(name: 'Trance').save()
      musician.hasManager = true
      musician.dateCreated = new Date()
      musician.lastUpdated = new Date()
      musician.formed = new Date()
    and: "We save contact and musician"
      musician.addToContacts(contact)
    and: "We add musician to user"
      user.addToMusicians(musician)
      user.save(flush: true)
    and: "We create an telephone"
      def telephonecontact1 = new Telephone(phone:'1234567890',phoneType:TelephoneType.WORK,contact: contact)
      def telephonecontact2 = new Telephone(phone:'1234567890',phoneType:TelephoneType.WORK,contact: contact)
      def telephonecontact3 = new Telephone(phone:'1234567890',phoneType:TelephoneType.WORK,contact: contact)
      def telephonecontact4 = new Telephone(phone:'1234567890',phoneType:TelephoneType.WORK,contact: contact)
    when: "We save telephone"
      contactService.saveTelephone(contact, telephonecontact1)
      contactService.saveTelephone(contact, telephonecontact2)
      contactService.saveTelephone(contact, telephonecontact3)
      contactService.saveTelephone(contact, telephonecontact4)
    then:"We expect exception"
      thrown ValidationException
    cleanup:"We delete contact"
      user.delete(flush: true)
  }

}
