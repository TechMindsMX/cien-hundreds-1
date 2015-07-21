package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class SocialService {

  def saveSocialToInstance(socialInstance, instance){
    instance.social = socialInstance
    instance.save flush:true

    return instance
  }

  def deleteSocialFromInstance(socialInstance, instance){
    if(!instance) return
    instance.social = null
    instance.save()

    socialInstance.delete()
  }

}
