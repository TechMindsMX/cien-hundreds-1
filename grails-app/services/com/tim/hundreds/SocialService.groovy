package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class SocialService {

  def deleteSocialFromInstance(socialInstance, instance){
    if(!instance) return
    instance.social = null
    instance.save()

    socialInstance.delete()
  }

}
