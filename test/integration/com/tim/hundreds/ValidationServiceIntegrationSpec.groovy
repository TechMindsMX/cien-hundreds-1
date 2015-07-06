package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

class ValidationServiceIntegrationSpec extends Specification {
  def validationService

  void "should validate an musician"() {
  given: "An user"
    def user = new User(username:'userValidationServiceSpec',password:'password')
    def profile = new Profile(email:'test1@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
    user.profile = profile
    user.save flush: true
  and: "A Musician"
    def musician = new Musician(name:'name',history:'history')
    musician.genre = new Genre(name: 'Trance').save()
    musician.hasManager = true
    musician.dateCreated = new Date()
    musician.lastUpdated = new Date()
    musician.formed = new Date()
    musician.user = user
    musician.save flush: true
    assert !musician.active
  and: "Musician validation"
    def instanceValidation = new MusicianValidation(message:'hi', type:ValidationType.ACCEPTED)
    instanceValidation.user = user
    instanceValidation.musician = musician
    instanceValidation.save flush: true
  when: "We validate musician"
    validationService.validate(instanceValidation, 'musician')
  then: "We expect musician validated"
    assert musician.active
  cleanup:"Deleting user"
    instanceValidation.delete flush:true
    musician.delete flush:true
    user.delete flush:true
  }

  void "should validate a company"() {
  given: "An user"
    def user = new User(username:'userValidationServiceSpec',password:'password')
    def profile = new Profile(email:'test1@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
    user.profile = profile
    user.save flush: true
  and: "A Company"
    def company = new Company(name:'name',description:'description')
    company.type = new BusinessActivity(name:'Products').save()
    company.user = user
    company.save flush: true
    assert !company.active
  and: "Musician validation"
    def instanceValidation = new CompanyValidation(message:'hi', type:ValidationType.ACCEPTED)
    instanceValidation.user = user
    instanceValidation.company = company
    instanceValidation.save flush: true
  when: "We validate musician"
    validationService.validate(instanceValidation, 'company')
  then: "We expect musician validated"
    assert company.active
  cleanup:"Deleting user"
    instanceValidation.delete flush:true
    company.delete flush:true
    user.delete flush:true
  }
}
