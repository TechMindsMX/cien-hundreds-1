package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class SocialContextService {
  def socialService

  def saveInstance(socialInstance) {
    if(socialInstance.musician){
      def musician = socialInstance.musician
      musician.social = socialInstance
      musician.save flush:true
    }
    if(socialInstance.contact){
      def contact = socialInstance.contact
      musician.social = socialInstance
      contact.save flush:true
    }
    if(socialInstance.company){
      def company = socialInstance.company
      company.social = socialInstance
      company.save flush:true
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
