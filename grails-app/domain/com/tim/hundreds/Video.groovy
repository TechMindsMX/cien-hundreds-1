package com.tim.hundreds

class Video {
  String uuid = TokenService.generateToken()
  String url

  static belongsTo = [
    musician : Musician
  ]

  static constraints = {
    url blank:false,size:10..100
  }

}
