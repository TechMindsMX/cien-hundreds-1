package com.tim.hundreds

import grails.transaction.Transactional
import com.tim.hundreds.User

@Transactional
class UserService {
  def userHelperService
  def recoveryService

  def create(def user){
    if(user){
      if(Profile.findByEmail(user.profile?.email))
        throw new DuplicatedEmailException('This email already exist')
      user.save()
      userHelperService.addUserRole(user)
      recoveryService.sendConfirmationAccountToken(user.profile?.email)
    }
    user
  }
}

