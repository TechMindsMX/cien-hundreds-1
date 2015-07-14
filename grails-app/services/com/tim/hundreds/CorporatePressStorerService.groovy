package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class CorporatePressStorerService implements StorerService {
  def grailsApplication

  String storeFile(def multipartFile){
    def directoryDestination = new File(grailsApplication.config.attachments.home + grailsApplication.config.base.press.directory)
    def fileName = TokenGenerator.generateToken() + grailsApplication.config.extension.resume
    File fileDestination = new File(directoryDestination,fileName)
    multipartFile.transferTo(fileDestination)
    fileName
  }
}
