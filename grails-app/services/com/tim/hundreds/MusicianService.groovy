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

    musicianInstance
  }

  def deleteSocial(socialInstance){
    def musician = Musician.findBySocial(socialInstance)
    musician.social = null
    musician.save()

    socialInstance.delete()
  }
}
