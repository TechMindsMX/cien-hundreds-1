package com.tim.hundreds

class ValidationMessage {
  String uuid = TokenGenerator.generateToken()
  String message

  static belongsTo = [
    user: User,
    musician: Musician
  ]

  static constraints = {
    message blank:false,size:1..10000
  }

}
