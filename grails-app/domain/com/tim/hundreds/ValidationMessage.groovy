package com.tim.hundreds

class ValidationMessage {
  String uuid = TokenGenerator.generateToken()
  String message

  Date dateCreated
  Date lastUpdated

  static belongsTo = [
    user: User,
    musician: Musician
  ]

  static constraints = {
    message blank:false,size:1..10000
  }

}
