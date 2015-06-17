package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class CompanyService {
  def springSecurityService

  def save(companyInstance) {
    def user = springSecurityService.currentUser
    user.addToCompanies(companyInstance)
    user.save()

    companyInstance
  }

  def delete(companyInstance){
    companyInstance.user = null
    companyInstance.save()
    companyInstance.delete(flush: true)
  }

}
