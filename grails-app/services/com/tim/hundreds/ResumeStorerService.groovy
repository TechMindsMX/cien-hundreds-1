package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class ResumeStorerService implements StorerService {
  def tokenService
  def resumePath = ApplicationState.ATTACH_DIR + ApplicationState.RESUME_DIRECTORY
  def directoryDestination = new File(resumePath)

  String storeFile(def multipartFile){
    def fileName = tokenService.generateToken() + ApplicationState.RESUME_EXTENSION
    File fileDestination = new File(directoryDestination,fileName)
    multipartFile.transferTo(fileDestination)
    fileName
  }
}
