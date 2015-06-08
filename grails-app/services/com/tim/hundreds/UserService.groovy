package com.tim.hundreds

import grails.transaction.Transactional
import com.tim.hundreds.User

@Transactional
class UserService {

  def userHelperService

  def create(def user){
    if(user){
      user.save(flush: true)
      userHelperService.addUserRole(user)
    }
    user
  }
}

