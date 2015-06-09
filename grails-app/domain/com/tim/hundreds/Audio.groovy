package com.tim.hundreds

class Audio {

  String link

  static belongsTo = [
    musician : Musician
  ]

  static constraints = {
    link blank:false,size:10..100
  }

}
