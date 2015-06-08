package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class PhotoService {

  def savePhoto(photoInstance){
    log.info "Photo count by musician: ${Photo.findByMusician(photoInstance.musician)?.count()}"

    def musician = photoInstance.musician
    musician.addToPhotos(photoInstance)
    musician.save(failOnError:true)

    photoInstance
  }

}
