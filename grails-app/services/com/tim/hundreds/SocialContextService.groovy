package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class SocialContextService {
  def socialService

  def saveInstance(socialInstance, params) {
    if(params.musicianUuid){
      def musician = Musician.findByUuid(params.musicianUuid)
      socialService.saveSocialToInstance(socialInstance, musician)
    }
    if(params.contactId){
      def contact = Contact.findById(params.contactId)
      socialService.saveSocialToInstance(socialInstance, contact)
    }
    if(params.companyId){
      def company = Company.findById(params.companyId)
      socialService.saveSocialToInstance(socialInstance, company)
    }
  }


  def deleteInstance(socialInstance) {
    def musician = Musician.findBySocial(socialInstance)
    socialService.deleteSocialFromInstance(socialInstance, musician)

    def contact = Contact.findBySocial(socialInstance)
    socialService.deleteSocialFromInstance(socialInstance, contact)

    def company = Company.findBySocial(socialInstance)
    socialService.deleteSocialFromInstance(socialInstance, company)
  }

}
