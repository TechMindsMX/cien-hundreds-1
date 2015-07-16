package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class MessengineService {
  def restService
  def grailsApplication

  def sendInstanceEditedMessage(def target, String instance) {
    def profile = target.user.profile
    def message = new AssignationCommand(email:profile.email, name:profile.firstName, reference:target.name)
    restService.sendCommand(message, grailsApplication.config."${instance}".edited.user.url)
  }
}
