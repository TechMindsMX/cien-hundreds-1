package com.tim.hundreds

class Audio {

  String path

  static belongsTo = [
    musician : Musician
  ]

  static constraints = {
    path blank:false,size:1..255
  }

}
