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
      def contact = new Contact(firstName:'firstName',lastName:'lastName',motherLastName:'motherLastName')
      contact.type = GenderType.MALE
      contact.role = new MusicianRole(name: 'Manager').save()
      contact.birthDate = new Date()
      contact.entryDate = new Date()
    and: "A user"
      def user = new User(username:'telephoneIntegration1',password:'password')
      def profile = new Profile(email:'telephoneIntegration1@email.com', firstName:'me', motherLastName:'motherLastName', lastName:'lastName')
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
      def telephonecontact = new Telephone(phone:'1234567890',type:TelephoneType.WORK,contact: contact)
    when: "We save telephone"
      def result = telephoneService.save(telephonecontact)
    then:"We validate command"
      result
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
      def user = new User(username:'telephoneIntegration2',password:'password')
      def profile = new Profile(email:'telephoneIntegration2@email.com', firstName:'me', motherLastName:'motherLastName', lastName:'lastName')
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
      def telephonecontact1 = new Telephone(phone:'1234567890',type:TelephoneType.WORK,contact: contact)
      def telephonecontact2 = new Telephone(phone:'1234567890',type:TelephoneType.WORK,contact: contact)
      def telephonecontact3 = new Telephone(phone:'1234567890',type:TelephoneType.WORK,contact: contact)
      def telephonecontact4 = new Telephone(phone:'1234567890',type:TelephoneType.WORK,contact: contact)
    when: "We save telephone"
      telephoneService.save(telephonecontact1)
      telephoneService.save(telephonecontact2)
      telephoneService.save(telephonecontact3)
      telephoneService.save(telephonecontact4)
    then:"We expect exception"
      thrown ValidationException
    cleanup:"We delete contact"
      user.delete(flush: true)
  }

}
