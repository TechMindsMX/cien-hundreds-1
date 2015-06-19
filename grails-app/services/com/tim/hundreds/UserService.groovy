package com.tim.hundreds

import grails.transaction.Transactional
import com.tim.hundreds.User

@Transactional
class UserService {
  def userHelperService
  def recoveryService

  def create(def user){
    if(user){
      log.info "user: ${user.dump()}"
      user.save()
      userHelperService.addUserRole(user)
      recoveryService.sendConfirmationAccountToken(user.profile?.email)
    }
    user
  }
}

