package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class PhotoService {
  def savePhoto(photoInstance){
    log.info "Photo count by musician: ${Photo.findByMusician(photoInstance.musician)?.count()}"
    def photoSize = Photo.findByMusician(photoInstance.musician)?.count()
    if(photoSize < ApplicationState.MAX_PHOTOS){
      photoInstance.save flush:true
    } else {
      throw new BusinessException()
    }
  }
}
