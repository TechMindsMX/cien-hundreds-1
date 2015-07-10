package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class LoginService {
  def grailsApplication
  def users = [:]

  def validateUsername(String username){
    def msg = 'springSecurity.errors.login.fail'

    def attemp = users.get(username)
    if(!attemp) attemp=0
    users.put(username,++attemp)
    if(attemp == grailsApplication.config.max.user.attemps){
      def user = User.findByUsername(username)
      if(user){
        user.accountLocked = true
        user.save flush:true
				msg = 'springSecurity.errors.login.locked'
      }else{
        msg = 'springSecurity.errors.login.fail'
      }
    }else if(attemp > grailsApplication.config.max.user.attemps){
		  msg = 'springSecurity.errors.login.locked'
    }
    msg
  }

}

