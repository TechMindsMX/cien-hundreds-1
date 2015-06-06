package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class PhotoStorerService implements StorerService {
  def tokenService
  def directoryDestination = new File(System.getProperty("java.io.tmpdir"))

  String storeFile(def multipartFile){
    def fileName = tokenService.generateToken() + ApplicationState.IMAGE_EXTENSION
    File fileDestination = new File(directoryDestination,fileName)
    multipartFile.transferTo(fileDestination)
    fileName
  }
}
