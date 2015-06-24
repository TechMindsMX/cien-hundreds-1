package com.tim.hundreds

class MusicianRole {
  String name

  static constraints = {
    name blank:false,size:1..50
  }

}
