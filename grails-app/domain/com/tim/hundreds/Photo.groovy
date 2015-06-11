package com.tim.hundreds

class Photo {
  String uuid = TokenService.generateToken()
  String path

  static belongsTo = [
    musician : Musician
  ]

  static constraints = {
    path blank:false,size:36..36
  }

}
