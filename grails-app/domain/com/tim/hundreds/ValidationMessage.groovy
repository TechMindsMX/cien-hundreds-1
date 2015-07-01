package com.tim.hundreds

class ValidationMessage {
  String uuid = TokenService.generateToken()
  String message

  static belongsTo = [
    user: User,
    musician: Musician
  ]

  static constraints = {
    message blank:false,size:1..10000
  }

}
