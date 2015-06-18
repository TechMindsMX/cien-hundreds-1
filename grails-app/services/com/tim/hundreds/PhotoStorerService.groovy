package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class PhotoStorerService implements StorerService {
  def tokenService
  def photoPath = ApplicationState.PHOTO_DIRECTORY
  def directoryDestination = new File(photoPath)

  String storeFile(def multipartFile){
    def fileName = tokenService.generateToken() + ApplicationState.IMAGE_EXTENSION
    File fileDestination = new File(directoryDestination,fileName)
    multipartFile.transferTo(fileDestination)
    fileName
  }
}
