package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class AudioService {

  def saveAudio(audioInstance){
    if(audioInstance.musician){
      def musician = audioInstance.musician
      musician.addToAudios(audioInstance)
      musician.save flush:true
    }
    if(audioInstance.contact){
      def contact = audioInstance.contact
      contact.addToAudios(audioInstance)
      contact.save flush:true
    }

    audioInstance
  }

  def resolveMusician(audioInstance) {
    if(audioInstance.musician){
      audioInstance.musician
    }
    if (audioInstance.contact){
      audioInstance.contact.musician
    }
  }
}
