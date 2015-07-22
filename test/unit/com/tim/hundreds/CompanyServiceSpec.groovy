package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(CompanyService)
@Mock([Company])
class CompanyServiceSpec extends Specification {

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
    def result = service.getcompaniesByDateCreated(startDate, endDate)
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
