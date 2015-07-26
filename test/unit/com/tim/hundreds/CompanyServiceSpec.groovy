package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(CompanyService)
@Mock([Company, CompanyValidation])
class CompanyServiceSpec extends Specification {
  def validationService = Mock(ValidationService)

  def setup() {
    service.validationService = validationService
  }

  void "should assign company to buyer and active company"() {
  given: "An company validation"
   def companyValidationInstance = Mock(CompanyValidation)
  and: "And companny and user"
   def company = Mock(Company)
   def user = Mock(User)
   companyValidationInstance.company >> company
   companyValidationInstance.user >> user
   when: "We assign values to the user"
   service.assignCompanyToBuyer(companyValidationInstance)
   then: "We expect company is save"
   1 * company.setProperty('assigned', user)
   1 * validationService.validate(companyValidationInstance, 'company')
   1 * company.save()
   1 * companyValidationInstance.save()
  }

  void "should not assign company to buyer and active company since no buyer"() {
  given: "An company validation"
   def companyValidationInstance = Mock(CompanyValidation)
  and: "And companny and user"
   def company = Mock(Company)
   def user = Mock(User)
   companyValidationInstance.musician >> company
   companyValidationInstance.user >> null
   when: "We assign values to the user"
   service.assignCompanyToBuyer(companyValidationInstance)
   then: "We expect company is save"
    thrown InvalidParamsException
  }

  void "should get companies by creation date"() {
  given: "A date range"
    def endDate = new Date()
    def startDate = endDate - 9
  and: "A company"
    def company = new Company()
    company.dateCreated = endDate - 1
    company.save(validate: false)
  when: "We try to get company by range"
    def result = service.getCompaniesByDateCreated(startDate, endDate)
  then:
    1 == result.size()
  }

  void "should not get companies by creation date since is not in range"() {
  given: "A date range"
    def endDate = new Date()
    def startDate = endDate - 9
  and: "A company"
    def company = new Company()
    company.dateCreated = endDate - 15
    company.save(validate: false)
  when: "We try to get company by range"
    def result = service.getCompaniesByDateCreated(startDate, endDate)
  then:
    result.isEmpty()
  }

  void "should get companies created same day"() {
  given: "A date range"
    def endDate = new Date()
    def startDate = endDate - 9
  and: "A company"
    def company = new Company()
    company.dateCreated = endDate
    company.save(validate: false)
  when: "We try to get company by range"
    def result = service.getCompaniesByDateCreated(startDate, endDate)
  then:
    1 == result.size()
  }

}
