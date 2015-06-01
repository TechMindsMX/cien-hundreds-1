package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class PhotoStorerService implements StorerService {
  def directoryDestination = new File(System.getProperty("java.io.tmpdir"))

  String storeFile(def multipartFile){
    def fileName = "photo.png"
    File fileDestination = new File(directoryDestination,fileName)
    multipartFile.transferTo(fileDestination)
    fileName
  }
}
