package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class AudioService {

  def saveAudio(audioInstance){
    def musician = audioInstance.musician
    musician.addToAudios(audioInstance)
    musician.save(failOnError: true)

    audioInstance
  }

}
