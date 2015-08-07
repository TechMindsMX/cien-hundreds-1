package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class AudioService {

  def saveAudio(audioInstance){
    if(audioInstance.musician){
      def musician = audioInstance.musician
      musician.addToAudios(audioInstance)
      musician.save failOnError: true
    }
    if(audioInstance.contact){
      def contact = audioInstance.contact
      contact.addToAudios(audioInstance)
      contact.save failOnError: true
    }

    audioInstance
  }

  def resolveMusician(audioInstance) {
    if(audioInstance.musician){
      return audioInstance.musician
    }
    if (audioInstance.contact){
      return audioInstance.contact.musician
    }
  }
}
