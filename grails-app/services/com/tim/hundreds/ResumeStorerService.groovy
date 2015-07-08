package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class ResumeStorerService implements StorerService {
  def grailsApplication

  String storeFile(def multipartFile){
    def directoryDestination = new File(grailsApplication.config.attachments.home + ApplicationState.RESUME_DIRECTORY)
    def fileName = TokenGenerator.generateToken() + ApplicationState.IMAGE_EXTENSION
    File fileDestination = new File(directoryDestination,fileName)
    multipartFile.transferTo(fileDestination)
    fileName
  }
}
