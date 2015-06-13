package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class RegistrationHelperService {

  def findEmailByToken(String token) {
    def registrationCode = RegistrationCode.findByToken(token)
    registrationCode.email
  }

  def isValidToken(String token){
     def registrationCode = RegistrationCode.findByToken(token)
     registrationCode.isValid()
  }

}
