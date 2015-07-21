package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class MusicianService {
  def springSecurityService
  def validationService

  def save(musicianInstance){
    if(!musicianInstance.user){
      def user = springSecurityService.currentUser
      user.addToMusicians(musicianInstance)
      user.save()
    } else {
      musicianInstance.save()
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

  def getMusiciansByDateCreated(String from, String to){
    if(from > to){
      throw new InvalidParamsException('Date from is greater')
    }
  }

}
