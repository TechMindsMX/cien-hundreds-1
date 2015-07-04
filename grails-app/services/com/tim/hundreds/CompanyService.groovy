package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class CompanyService {
  def springSecurityService
  def validationService

  def save(companyInstance) {
    def user = springSecurityService.currentUser
    user.addToCompanies(companyInstance)
    user.save()

    companyInstance
  }

  def assignCompanyToBuyer(companyValidationInstance){
    def company = companyValidationInstance.company
    company.assigned = companyValidationInstance.user
    validationService.validate(companyValidationInstance, 'company')
    company.save()
    companyValidationInstance.save()
  }

}
