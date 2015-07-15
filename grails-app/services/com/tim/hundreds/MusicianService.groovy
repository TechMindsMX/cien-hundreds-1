package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class MusicianService {
  def springSecurityService
  def validationService

  def save(musicianInstance){
    log.info "musicianInstance: ${musicianInstance.dump()}"
    if(!musicianInstance.id){
      def user = springSecurityService.currentUser
      user.addToMusicians(musicianInstance)
      user.save()
    } else {
      musicianInstance.save flush:true
    }

    musicianInstance
  }

  def assignMusicianToFacilitator(musicianValidationInstance){
    def musician = musicianValidationInstance.musician
    musician.assigned = musicianValidationInstance.user
    validationService.validate(musicianValidationInstance, 'musician')
    musician.save()
    musicianValidationInstance.save()
  }

}
