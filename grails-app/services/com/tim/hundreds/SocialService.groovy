package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class SocialService {

  def save(socialInstance, musicianId){
    socialInstance.save flush:true
    def musician = Musician.findById(musicianId)
    musician.social = socialInstance
    musician.save()
  }

}
