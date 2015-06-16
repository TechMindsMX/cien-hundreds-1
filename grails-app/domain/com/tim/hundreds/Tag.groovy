package com.tim.hundreds

class Tag {
  String value

  static belongsTo = [musician : Musician]

  static constraints = {
    value blank:false,size:1..50
  }
}
