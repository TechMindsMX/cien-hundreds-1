package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class AudioService {

  def saveAudio(audioInstance){
    log.info "Audio count by user: ${Audio.findByMusician(audioInstance.musician)?.count()}"

    def musician = audioInstance.musician
    musician.addToAudios(audioInstance)
    musician.save(failOnError: true)

    audioInstance
  }

}
