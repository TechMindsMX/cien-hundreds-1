package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class MusicianService {
  def springSecurityService

  def save(musicianInstance){
    def user = springSecurityService.currentUser
    user.addToMusicians(musicianInstance)
    user.save()

    musicianInstance
  }

}
