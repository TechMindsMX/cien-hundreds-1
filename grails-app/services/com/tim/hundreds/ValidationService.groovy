package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class ValidationService {
  def restService
  def grailsApplication

  def validateMusician(musicianValidationInstance) {
    def musician = musicianValidationInstance.musician
    def facilitator = musicianValidationInstance.user
    def active = musicianValidationInstance.type == ValidationType.ACCEPTED ? true : false
    musician.active = active
    if(active){
      def profile = facilitator.profile
      def message = new AssignationCommand(email:profile.email, name:"${profile.firstName} ${profile.middleName} ${profile.lastName}", reference:musician.name)
      restService.sendCommand(message, grailsApplication.config.musician.assigned.facilitator.url)

      profile = musician.user.profile
      message = new AssignationCommand(email:profile.email, name:"${profile.firstName} ${profile.middleName} ${profile.lastName}", reference:musician.name, emailOptional:musician.user.profile.email)
      restService.sendCommand(message, grailsApplication.config.musician.assigned.user.url)

    } else {
      def profile = musician.user.profile
      def message = new AssignationCommand(email:profile.email, name:"${profile.firstName} ${profile.middleName} ${profile.lastName}", reference:musician.name)
      restService.sendCommand(message, grailsApplication.config.musician.refused.url)
    }
  }

  def validateCompany(companyValidationInstance) {
    def company = companyValidationInstance.company
    def buyer = companyValidationInstance.user
    def active = companyValidationInstance.type == ValidationType.ACCEPTED ? true : false
    company.active = active
    if(active){
      def profile = buyer.profile
      def message = new AssignationCommand(email:profile.email, name:"${profile.firstName} ${profile.middleName} ${profile.lastName}", reference:company.name)
      restService.sendCommand(message, grailsApplication.config.company.assigned.buyer.url)

      profile = company.user.profile
      message = new AssignationCommand(email:profile.email, name:"${profile.firstName} ${profile.middleName} ${profile.lastName}", reference:musician.name, emailOptional:company.user.profile.email)
      restService.sendCommand(message, grailsApplication.config.company.assigned.user.url)

    } else {
      def profile = company.user.profile
      def message = new AssignationCommand(email:profile.email, name:"${profile.firstName} ${profile.middleName} ${profile.lastName}", reference:company.name)
      restService.sendCommand(message, grailsApplication.config.company.refused.url)
    }

  }

}
