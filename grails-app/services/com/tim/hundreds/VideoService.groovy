package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class VideoService {

  def saveVideo(videoInstance){
    def musician = videoInstance.musician
    musician.addToVideos(videoInstance)
    musician.save(failOnError:true)

    videoInstance
  }
}
