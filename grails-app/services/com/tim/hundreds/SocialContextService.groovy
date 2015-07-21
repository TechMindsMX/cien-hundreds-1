package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class SocialContextService {
  def socialService

  def saveInstance(socialInstance, params) {
    if(params.musician?.id){
      def musician = Musician.findById(params.musician.id)
      socialService.saveSocialToInstance(socialInstance, musician)
    }
    if(params.contact?.id){
      def contact = Contact.findById(params.contact.id)
      socialService.saveSocialToInstance(socialInstance, contact)
    }
    if(params.company?.id){
      def company = Company.findById(params.company.id)
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
