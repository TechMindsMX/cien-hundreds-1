package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class LoginService {
  def users = [:]

  def validateUsername(String username){
    def msg = 'springSecurity.errors.login.fail'

    def attemp = users.get(username)
    if(!attemp) attemp=0
    users.put(username,++attemp)
    log.info "attemp: ${attemp}"
    if(attemp == ApplicationState.MAX_USER_ATTEMPS){
      def user = User.findByUsername(username)
      if(user){
        user.accountLocked = true
        user.save flush:true
				msg = 'springSecurity.errors.login.locked'
      }else{
        msg = 'springSecurity.errors.login.fail'
      }
    }else if(attemp > ApplicationState.MAX_USER_ATTEMPS){
		  msg = 'springSecurity.errors.login.locked'
    }
    msg
  }

}

