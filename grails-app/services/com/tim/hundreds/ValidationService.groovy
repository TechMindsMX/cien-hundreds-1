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
    def targetProfile = target.profile
    def userProfile = domain.user.profile
    if(active){
      log.info "profile user: ${targetProfile.dump()}"
      def targetMessage = new AssignationCommand(email:targetProfile.email, name:"${targetProfile.firstName} ${targetProfile.middleName} ${targetProfile.lastName}", reference:domain.name)
      restService.sendCommand(targetMessage, grailsApplication.config."${instance}".assigned.facilitator.url)
      log.info "profile domain: ${userProfile.dump()}"
      log.info "user email: ${userProfile.email}"
      log.info "facilitator email: ${targetProfile.email}"

      def userMessage = new AssignationCommand(email:userProfile.email, name:"${userProfile.firstName} ${userProfile.middleName} ${userProfile.lastName}", reference:domain.name, emailOptional:targetProfile.email)
      log.info "message: ${userMessage.dump()}"
      restService.sendCommand(userMessage, grailsApplication.config."${instance}".assigned.user.url)
    } else {
      def refusedMessage = new AssignationCommand(email:profile.email, name:"${userProfile.firstName} ${userProfile.middleName} ${userProfile.lastName}", reference:domain.name)
      restService.sendCommand(refusedMessage, grailsApplication.config."${instance}".refused.url)
    }
  }

}
