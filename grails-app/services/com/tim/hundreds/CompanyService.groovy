package com.tim.hundreds

import grails.transaction.Transactional
import grails.plugin.springsecurity.SpringSecurityUtils

@Transactional
class CompanyService {
  def springSecurityService
  def validationService

  def save(companyInstance) {
    if(!companyInstance.user){
      def user = springSecurityService.currentUser
      user.addToCompanies(companyInstance)
      user.save()
    } else {
      companyInstance.save()
    }

    companyInstance
  }

  def assignCompanyToBuyer(companyValidationInstance){
    def company = companyValidationInstance.company
    if(!companyValidationInstance.user){
      throw new InvalidParamsException('No buyer was provided')
    }

    def validationExist = CompanyValidation.findByCompanyAndUser(companyValidationInstance.musician, companyValidationInstance.user)
    if(validationExist){
      throw new InvalidParamsException('This company was already assignated to that buyer')
    }
    company.assigned = companyValidationInstance.user
    validationService.validate(companyValidationInstance, 'company')
    company.save()
    companyValidationInstance.save()
  }

  def getCompaniesByDateCreated(Date startDate, Date endDate){
    if(startDate>endDate){
      throw new InvalidParamsException('Date from is greater')
    }
    Company.findAllByDateCreatedBetween(startDate, endDate + 1)
  }

  def getCompanyList (User currentUser, params) {
    def companyList = [list: null, count: null]
        if (SpringSecurityUtils.ifAnyGranted('ROLE_USER')) {
            companyList.list = Company.findAllByUser(currentUser, [max: params.max, sort: "name", order: "asc", offset: params.offset ?: 0])
            companyList.count = Company.findAllByUser(currentUser).size()
        } else if (SpringSecurityUtils.ifAnyGranted('ROLE_BUYER')) {
            companyList.list = Company.findAllByAssigned(currentUser, [max: params.max, sort: "name", order: "asc", offset: params.offset ?: 0])
            companyList.count =  Company.findAllByUser(currentUser).size()
        } else {
            companyList.list = Company.list(params)
            companyList.count =  Company.count()
        }
        companyList
  }
}
