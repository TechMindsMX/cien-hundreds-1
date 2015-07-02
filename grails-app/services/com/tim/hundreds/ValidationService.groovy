package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class ValidationService {
  def restService
  def grailsApplication

  def validate(musicianValidationInstance) {
    def musician = musicianValidationInstance.musician
    def user = musicianValidationInstance.user
    def active = musicianValidationInstance.type == ValidationType.ACCEPTED ? true : false
    musician.active = active
    if(active){
      def message = new FacilitatorCommand(email:user.profile.email, facilitator:"${user.profile.firstName} ${user.profile.middleName} ${user.profile.lastName}", musician:musician.name)
      restService.sendCommand(message, grailsApplication.config.facilitator.assigned.url)
    }
  }

}
