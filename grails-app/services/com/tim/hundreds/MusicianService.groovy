package com.tim.hundreds

import grails.transaction.Transactional
import grails.plugin.springsecurity.SpringSecurityUtils

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
    if(!musicianValidationInstance.user){
      throw new InvalidParamsException('No facilitator was provided')
    }

    def validationExist = MusicianValidation.findByMusicianAndUser(musicianValidationInstance.musician, musicianValidationInstance.user)
    if(validationExist){
      throw new InvalidParamsException('This musician was already assignated to that facilitator')
    }

    musician.assigned = musicianValidationInstance.user
    validationService.validate(musicianValidationInstance, 'musician')
    musician.save()
    musicianValidationInstance.save()
  }

  def getMusiciansByDateCreated(Date startDate, Date endDate){
    if(startDate>endDate){
      throw new InvalidParamsException('Date from is greater')
    }
    Musician.findAllByDateCreatedBetween(startDate, endDate + 1)
  }

  def getMusicianList (User currentUser, params) {
    def musicianList = [list: null, count: null]
        if (SpringSecurityUtils.ifAnyGranted('ROLE_USER')) {
            musicianList.list = Musician.findAllByUser(currentUser, [max: params.max, sort: "name", order: "asc", offset: params.offset ?: 0])
            musicianList.count = Musician.findAllByUser(currentUser).size()
        } else if (SpringSecurityUtils.ifAnyGranted('ROLE_FACILITATOR')) {
            musicianList.list = Musician.findAllByAssigned(currentUser, [max: params.max, sort: "name", order: "asc", offset: params.offset ?: 0])
            musicianList.count =  Musician.findAllByUser(currentUser).size()
        } else {
            musicianList.list = Musician.list(params)
            musicianList.count =  Musician.count()
        }
        musicianList
  }

  def canAskForValidation(Musician musicianInstance) {
    return !musicianInstance.active
  }

}
