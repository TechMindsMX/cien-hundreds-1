package com.tim.hundreds

import grails.transaction.Transactional
import com.tim.hundreds.User
import com.tim.hundreds.UserRole
import com.tim.hundreds.Role

@Transactional
class UserService {

  def create(def user){
    if(user){
      def userRole = Role.findWhere(authority: 'ROLE_USER')
      user.save(flush: true)
      UserRole.create user, userRole, true
    }
    user
  }
}

