package com.tim.hundreds

class Photo {

  String uuid = TokenGenerator.generateToken()
  String path

  Date dateCreated
  Date lastUpdated

  static belongsTo = [
    musician : Musician
  ]

  static constraints = {
    path blank:false,size:36..36
  }

}
