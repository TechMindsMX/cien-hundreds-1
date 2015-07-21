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
    def targetProfile = target.profile
    def userProfile = domain.user.profile
    domain.active = active
    if(active){
      def message = new AssignationCommand(email:targetProfile.email, name:"${targetProfile.firstName}", reference:domain.name)
      restService.sendCommand(message, grailsApplication.config."${instance}".assigned.target.url)

      message = new AssignationCommand(email:userProfile.email, name:"${targetProfile.firstName}", reference:domain.name, emailOptional:targetProfile.email)
      restService.sendCommand(message, grailsApplication.config."${instance}".assigned.user.url)
    } else {
      def message = new AssignationCommand(email:userProfile.email, name:"${userProfile.firstName}", reference:domain.name)
      restService.sendCommand(message, grailsApplication.config."${instance}".refused.url)
    }

    instanceValidation
  }

}
