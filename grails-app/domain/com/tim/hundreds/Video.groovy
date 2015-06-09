package com.tim.hundreds

class Video {

  String url

  static belongsTo = [
    musician : Musician
  ]

  static constraints = {
    url blank:false,size:1..100
  }

}
