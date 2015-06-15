package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class LogoStorerService implements StorerService {
  def tokenService
  def directoryDestination = new File(ApplicationState.LOGO_PATH)

  String storeFile(def multipartFile){
    def fileName = tokenService.generateToken() + ApplicationState.IMAGE_EXTENSION
    File fileDestination = new File(directoryDestination,fileName)
    multipartFile.transferTo(fileDestination)
    fileName
  }
}
