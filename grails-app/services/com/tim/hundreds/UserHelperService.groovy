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
      if (it.getAuthorities().authority.findAll {it in roles}) {
        userList << it
      }
    }
    userList
  }

}
