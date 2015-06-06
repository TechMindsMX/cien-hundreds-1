package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class MusicianService {
  def springSecurityService

  def save(musicianInstance){
    musicianInstance.save()
    def user = springSecurityService.currentUser
    user.addToMusicians(musicianInstance)
    user.save()
  }
}
