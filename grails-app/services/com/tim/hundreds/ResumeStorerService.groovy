package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class ResumeStorerService implements StorerService {
  def directoryDestination = new File(System.getProperty("java.io.tmpdir"))

  String storeFile(def multipartFile){
    def fileName = "resume.pdf"
    File fileDestination = new File(directoryDestination,fileName)
    multipartFile.transferTo(fileDestination)
    fileName
  }
}
