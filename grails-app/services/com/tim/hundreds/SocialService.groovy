package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class SocialService {

  def saveSocialToInstance(socialInstance, instance){
    socialInstance.save flush:true
    instance.social = socialInstance
    instance.save()

    instance
  }

  def deleteSocialFromInstance(socialInstance, instance){
    if(!instance) return
    instance.social = null
    instance.save()

    socialInstance.delete()
  }

}
