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
      def message = new FacilitatorCommand(email:profile.email, facilitator:"${profile.firstName} ${profile.middleName} ${profile.lastName}", musician:musician.name)
      restService.sendCommand(message, grailsApplication.config.facilitator.assigned.url)
    } else {
      def profile = musician.user.profile
      def message = new FacilitatorCommand(email:profile.email, facilitator:"${profile.firstName} ${profile.middleName} ${profile.lastName}", musician:musician.name)
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
      def message = new FacilitatorCommand(email:profile.email, facilitator:"${profile.firstName} ${profile.middleName} ${profile.lastName}", musician:company.name)
      restService.sendCommand(message, grailsApplication.config.buyer.assigned.url)
    } else {
      def profile = company.user.profile
      def message = new FacilitatorCommand(email:profile.email, facilitator:"${profile.firstName} ${profile.middleName} ${profile.lastName}", musician:company.name)
      restService.sendCommand(message, grailsApplication.config.company.refused.url)
    }

  }

}
