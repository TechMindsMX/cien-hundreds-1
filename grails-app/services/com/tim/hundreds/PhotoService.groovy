package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class PhotoService {

  def savePhoto(photoInstance){
    if(photoInstance.musician){
      def musician = photoInstance.musician
      musician.addToPhotos(photoInstance)
      musician.save failOnError: true
    }
    if(photoInstance.contact){
      def contact = photoInstance.contact
      contact.addToPhotos(photoInstance)
      contact.save failOnError: true
    }

    photoInstance
  }

  def resolveMusician(photoInstance) {
    if(photoInstance.musician){
      photoInstance.musician
    }
    if (photoInstance.contact){
      photoInstance.contact.musician
    }
  }

}
