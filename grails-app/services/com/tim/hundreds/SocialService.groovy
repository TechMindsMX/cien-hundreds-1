package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class SocialService {

  def saveSocialToInstance(socialInstance, instance){
    socialInstance.save flush:true
    instance.social = socialInstance
    instance.save()
  }

}
