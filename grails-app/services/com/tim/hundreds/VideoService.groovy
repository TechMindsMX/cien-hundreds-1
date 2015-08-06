package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class VideoService {

  def saveVideo(videoInstance){
    if(videoInstance.musician){
      def musician = videoInstance.musician
      musician.addToVideos(videoInstance)
      musician.save failOnError: true
    }
    if(videoInstance.contact){
      def contact = videoInstance.contact
      contact.addToVideos(videoInstance)
      contact.save failOnError: true
    }

    videoInstance
  }
  
  def resolveMusician(videoInstance) {
    if(videoInstance.musician){
      videoInstance.musician
    }
    if (videoInstance.contact){
      videoInstance.contact.musician
    }
  }
}
