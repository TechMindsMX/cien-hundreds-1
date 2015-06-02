package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class VideoService {
  def saveVideo(videoInstance){
    log.info "Video count by user: ${Video.findByMusician(videoInstance.musician)?.count()}"
    def videoSize = Video.findByMusician(videoInstance.musician)?.count()
    if(videoSize < ApplicationState.MAX_VIDEOS){
      videoInstance.save flush:true
    } else {
      throw new BusinessException()
    }
  }
}
