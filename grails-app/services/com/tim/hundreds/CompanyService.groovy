package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class CompanyService {
  def springSecurityService

  def save(companyInstance) {
    companyInstance.save()
    def user = springSecurityService.currentUser
    user.addToCompanies(companyInstance)
    user.save()
  }
}
