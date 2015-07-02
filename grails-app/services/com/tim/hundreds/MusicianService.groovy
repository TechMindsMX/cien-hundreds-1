package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class MusicianService {
  def springSecurityService
  def validationService

  def save(musicianInstance){
    def user = springSecurityService.currentUser
    user.addToMusicians(musicianInstance)
    user.save()

    musicianInstance
  }

  def assignMusicianToFacilitator(musicianValidationInstance){
    def musician = musicianValidationInstance.musician
    musician.assigned = musicianValidationInstance.user
    validationService.validate(musicianValidationInstance)
    musician.save()
    musicianValidationInstance.save()
  }

}
