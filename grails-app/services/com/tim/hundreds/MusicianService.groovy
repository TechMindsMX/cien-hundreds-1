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

  def delete(musicianInstance){
    musicianInstance.user = null
    musicianInstance.save()
    musicianInstance.delete(flush: true)
  }

}
