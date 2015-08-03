package com.tim.hundreds

class MusicianValidation {
  String uuid = TokenGenerator.generateToken()
  String message
  ValidationType type

  Date dateCreated
  Date lastUpdated

  static belongsTo = [
    user: User,
    musician: Musician
  ]

  static constraints = {
    message nullable:true,blank:false,size:1..10000
  }

}
