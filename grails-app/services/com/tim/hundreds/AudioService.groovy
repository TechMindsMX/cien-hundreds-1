package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class AudioService {
  def saveAudio(audioInstance){
    log.info "Audio count by user: ${Audio.findByMusician(audioInstance.musician)?.count()}"
    def audiosSize = Audio.findByMusician(audioInstance.musician)?.count()
    if(audiosSize < ApplicationState.MAX_AUDIOS){
      audioInstance.save flush:true
    } else {
      throw new BusinessException()
    }
  }
}
