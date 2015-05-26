package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class UserService {

  def create(def user){
    user?.save()
    user
  }
}

