package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class MessengineService {
  def restService
  def grailsApplication

  def sendInstanceEditedMessage(def target, String instance) {
    log.info "target: ${target.dump()}"
    def userProfile = target.user.profile
    def targetProfile = target.assigned?.profile

    def message = new AssignationCommand(email:userProfile.email, name:userProfile.firstName, reference:target.name)
    restService.sendCommand(message, grailsApplication.config."${instance}".edited.user.url)

    if(targetProfile){
      message = new AssignationCommand(email:targetProfile.email, name:targetProfile.firstName, reference:target.name)
      restService.sendCommand(message, grailsApplication.config."${instance}".edited.user.url)
    }
  }

  def sendMusicianAskValidationMessage(User to, Musician musician, String instance) {
    def userProfile = to.profile

    def message = new AssignationCommand(email:userProfile.email, name:userProfile.firstName, reference:musician.name)
    restService.sendCommand(message, grailsApplication.config."${instance}".askValidation.url)
  }
}
