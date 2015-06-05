package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class SocialContextService {
  def socialService

  def saveInstance(socialInstance, params) {
    if(params.musicianId){
      def musician = Musician.findById(params.musicianId)
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
}
