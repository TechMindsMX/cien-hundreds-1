package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class LogoStorerService implements StorerService {
  def logoPath = ApplicationState.ATTACH_DIR + ApplicationState.LOGO_DIRECTORY
  def directoryDestination = new File(logoPath)

  String storeFile(def multipartFile){
    def fileName = TokenGenerator.generateToken() + ApplicationState.IMAGE_EXTENSION
    File fileDestination = new File(directoryDestination,fileName)
    multipartFile.transferTo(fileDestination)
    fileName
  }
}
