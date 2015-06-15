package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class RecoveryCollaboratorService {

  def generateToken(String email){
    def registration = new RegistrationCode(email:email)
    registration.save()
    def message = new TokenCommand(email:email, token:registration.token)

    message
  }

  def findRegistrationCode(token){
    def registrationCode = RegistrationCode.findByTokenAndStatus(token, RegistrationCodeStatus.VALID)
    if(!registrationCode) throw new BusinessException("User not found")

    registrationCode
  }

  def saveRegistrationCode(token){
    def registrationCode = RegistrationCode.findByTokenAndStatus(token, RegistrationCodeStatus.VALID)
    registrationCode.status = RegistrationCodeStatus.INVALID
    registrationCode.save()
  }

}
