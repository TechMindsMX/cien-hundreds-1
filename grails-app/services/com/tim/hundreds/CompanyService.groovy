package com.tim.hundreds

import grails.transaction.Transactional

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

}
