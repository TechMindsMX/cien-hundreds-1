package com.tim.hundreds

class Audio {

  String url

  static belongsTo = [
    musician : Musician
  ]

  static constraints = {
    url blank:false,size:10..100
  }

}
