package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class CorporatePressStorerService implements StorerService {
  def grailsApplication

  String storeFile(def multipartFile){
    def directoryDestination = new File(grailsApplication.config.attachments.home + ApplicationState.PRESS_DIRECTORY)
    def fileName = TokenGenerator.generateToken() + ApplicationState.RESUME_EXTENSION
    File fileDestination = new File(directoryDestination,fileName)
    multipartFile.transferTo(fileDestination)
    fileName
  }
}
