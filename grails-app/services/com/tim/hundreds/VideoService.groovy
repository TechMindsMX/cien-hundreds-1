package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class VideoService {

  def saveVideo(videoInstance){
    log.info "Video count by user: ${Video.findByMusician(videoInstance.musician)?.count()}"

    def musician = videoInstance.musician
    musician.addToVideos(videoInstance)
    musician.save(failOnError:true)

    videoInstance
  }
}
