package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.validation.ValidationException

class CollaboratorServiceIntegrationSpec extends Specification {
  def collaboratorService

  void "should save an email"() {
  given: "An collaborator"
    def collaborator = new Collaborator(firstName: 'firstName', middleName: 'middleName', lastName: 'lastName', position: 'position')
  and: "A user"
    def user = new User(username:'collaboratorServiceIntegration1',password:'password')
    def profile = new Profile(email:'collaboratorServiceIntegration1@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
    user.profile = profile
  and: "A Company"
    def company = new Company(name:'Anjunabeats',description:'Music Production')
    company.type = new BusinessActivity(name:'Products').save()
  and: "We save collaborator and company"
    company.addToCollaborators(collaborator)
  and: "We add company to user"
    user.addToCompanies(company)
    user.save(flush: true)
  and: "An email"
    def email = new Email(address: 'josdem@email.com', type: EmailType.PERSONAL)
  when: "We save an email"
    def result = collaboratorService.saveEmail(collaborator, email)
  then: "We expect"
     1 == result.emails.size()
     result
   cleanup:"We delete collaborator"
     user.delete(flush: true)

  }

  void "should save an telephone"() {
  given: "An collaborator"
    def collaborator = new Collaborator(firstName: 'firstName', middleName: 'middleName', lastName: 'lastName', position: 'position')
  and: "A user"
    def user = new User(username:'collaboratorServiceIntegration2',password:'password')
    def profile = new Profile(email:'collaboratorServiceIntegration2@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
    user.profile = profile
  and: "A Company"
    def company = new Company(name:'Anjunabeats',description:'Music Production')
    company.type = new BusinessActivity(name:'Products').save()
  and: "We save collaborator and company"
    company.addToCollaborators(collaborator)
  and: "We add company to user"
    user.addToCompanies(company)
    user.save(flush: true)
  and: "An telephone"
    def telephone = new Telephone(phone: '5512345678', type: TelephoneType.WORK)
  when: "We save an email"
    def result = collaboratorService.saveTelephone(collaborator, telephone)
  then: "We expect"
     1 == result.telephones.size()
     result
   cleanup:"We delete collaborator"
     user.delete(flush: true)

  }

  void "Should not save an collaborator with more than 3 emails"() {
    given: "An collaborator"
      def collaborator = new Collaborator(firstName:'firstName',middleName:'middleName',lastName:'lastName', position:'position')
    and: "A user"
      def user = new User(username:'collaboratorServiceIntegration3',password:'password')
      def profile = new Profile(email:'collaboratorServiceIntegration3@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
      user.profile = profile
    and: "A Company"
      def company = new Company(name:'Anjunabeats',description:'Music Production')
      company.type = new BusinessActivity(name:'Products').save()
    and: "We save collaborator and musician"
      company.addToCollaborators(collaborator)
    and: "We add musician to user"
      user.addToCompanies(company)
      user.save(flush: true)
    and: "We create several emails"
      def emailInstance1 = new Email(address:'josdem@email.com',type:EmailType.WORK)
      def emailInstance2 = new Email(address:'josdem@email.com',type:EmailType.WORK)
      def emailInstance3 = new Email(address:'josdem@email.com',type:EmailType.WORK)
      def emailInstance4 = new Email(address:'josdem@email.com',type:EmailType.WORK)
    when: "We save emails"
      collaboratorService.saveEmail(collaborator, emailInstance1)
      collaboratorService.saveEmail(collaborator, emailInstance2)
      collaboratorService.saveEmail(collaborator, emailInstance3)
      collaboratorService.saveEmail(collaborator, emailInstance4)
    then:"We expect exception"
      thrown ValidationException
    cleanup:"We delete collaborator"
      user.delete(flush: true)
  }

  void "Should not save an collaborator with more than 3 telephones"() {
    given: "An collaborator"
      def collaborator = new Collaborator(firstName:'firstName',middleName:'middleName',lastName:'lastName', position:'position')
    and: "A user"
      def user = new User(username:'collaboratorServiceIntegration4',password:'password')
      def profile = new Profile(email:'collaboratorServiceIntegration4@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
      user.profile = profile
    and: "A Company"
      def company = new Company(name:'Anjunabeats',description:'Music Production')
      company.type = new BusinessActivity(name:'Products').save()
    and: "We save collaborator and musician"
      company.addToCollaborators(collaborator)
    and: "We add musician to user"
      user.addToCompanies(company)
      user.save(flush: true)
    and: "We create an telephone"
      def telephoneCollaborator1 = new Telephone(phone:'1234567890',type:TelephoneType.WORK)
      def telephoneCollaborator2 = new Telephone(phone:'1234567890',type:TelephoneType.WORK)
      def telephoneCollaborator3 = new Telephone(phone:'1234567890',type:TelephoneType.WORK)
      def telephoneCollaborator4 = new Telephone(phone:'1234567890',type:TelephoneType.WORK)
    when: "We save telephone"
      collaboratorService.saveTelephone(collaborator, telephoneCollaborator1)
      collaboratorService.saveTelephone(collaborator, telephoneCollaborator2)
      collaboratorService.saveTelephone(collaborator, telephoneCollaborator3)
      collaboratorService.saveTelephone(collaborator, telephoneCollaborator4)
    then:"We expect exception"
      thrown ValidationException
    cleanup:"We delete collaborator"
      user.delete(flush: true)
  }

}
