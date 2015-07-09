package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class UserHelperService {

  def addUserRole(def user){
    log.info "user: ${user.dump()}"
    def userRole = Role.findWhere(authority: user.profile.role)
    UserRole.create user, userRole, true
  }

  def findByEmail(String email){
    def profile = Profile.findByEmail(email)
    def user = User.findByProfile(profile)

    user
  }

  def findListByRole(List roles) {
    def userList = []
    def tmp = User.findAll().each {
      if (roles.each() in it.getAuthorities().authority) {
        userList << it
      }
    }

    userList
  }


}
