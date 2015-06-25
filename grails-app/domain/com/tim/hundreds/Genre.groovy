package com.tim.hundreds

class Genre {
  String name

  static constraints = {
    name blank:false,size:1..50
  }
}
