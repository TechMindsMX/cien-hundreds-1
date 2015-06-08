package com.tim.hundreds

class Photo {

  String path

  static belongsTo = [
    musician : Musician
  ]

  static constraints = {
    path blank:false,size:1..100
  }

}
