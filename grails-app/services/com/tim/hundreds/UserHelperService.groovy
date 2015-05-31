package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class UserHelperService {

  def addUserRole(def user){
    def userRole = Role.findWhere(authority: 'ROLE_USER')
    UserRole.create user, userRole, true
  }

}
