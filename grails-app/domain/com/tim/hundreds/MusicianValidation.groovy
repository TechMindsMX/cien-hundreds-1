package com.tim.hundreds

class MusicianValidation {
  String uuid = TokenService.generateToken()
  String message
  Boolean status

  static belongsTo = [
    user: User,
    musician: Musician
  ]

  static constraints = {
    message nullable:true,blank:false,size:1..10000
  }

}
