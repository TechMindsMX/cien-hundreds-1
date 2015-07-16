package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class MusicianService {
  def springSecurityService
  def validationService

  def save(musicianInstance){
    log.info "musicianInstance: ${musicianInstance.dump()}"
    def user = springSecurityService.currentUser
    user.addToMusicians(musicianInstance)
    user.save()

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
