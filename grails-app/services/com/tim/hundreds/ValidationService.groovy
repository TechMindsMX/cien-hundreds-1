package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class ValidationService {
  def restService
  def grailsApplication

  def validate(def instanceValidation, String instance) {
    def domain = instanceValidation."${instance}"
    def target = instanceValidation.user
    def active = instanceValidation.type == ValidationType.ACCEPTED ? true : false
    domain.active = active
    if(active){
      def profile = target.profile
      def message = new AssignationCommand(email:profile.email, name:"${profile.firstName} ${profile.middleName} ${profile.lastName}", reference:"${instance}".name)
      restService.sendCommand(message, grailsApplication.config."${instance}".assigned.facilitator.url)

      profile = musician.user.profile
      message = new AssignationCommand(email:profile.email, name:"${profile.firstName} ${profile.middleName} ${profile.lastName}", reference:musician.name, emailOptional:musician.user.profile.email)
      restService.sendCommand(message, grailsApplication.config."${instance}".assigned.user.url)

    } else {
      def profile = "${instance}".user.profile
      def message = new AssignationCommand(email:profile.email, name:"${profile.firstName} ${profile.middleName} ${profile.lastName}", reference:"${instance}".name)
      restService.sendCommand(message, grailsApplication.config."${instance}".refused.url)
    }
  }

}
