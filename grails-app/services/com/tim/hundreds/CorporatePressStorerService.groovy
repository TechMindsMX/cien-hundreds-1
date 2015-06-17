package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class CorporatePressStorerService implements StorerService {
  def tokenService
  def corporatePressPath = "${System.getProperty('user.home')}" + ApplicationState.PHOTO_DIRECTORY
  def directoryDestination = new File(corporatePressPath)

  String storeFile(def multipartFile){
    def fileName = tokenService.generateToken() + ApplicationState.IMAGE_EXTENSION
    File fileDestination = new File(directoryDestination,fileName)
    multipartFile.transferTo(fileDestination)
    fileName
  }
}
