package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class SocialService {

  def saveMusician(socialInstance, musician){
    socialInstance.save flush:true
    musician.social = socialInstance
    musician.save()
  }

  def saveContact(socialInstance, contact){
    socialInstance.save flush:true
    contact.social = socialInstance
    contact.save()
  }

}
