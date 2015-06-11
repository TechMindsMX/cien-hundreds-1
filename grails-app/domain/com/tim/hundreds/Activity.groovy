package com.tim.hundreds

class Activity {
  String uuid = TokenService.generateToken()
  String activity
  String place
  Date date

  static belongsTo = [ musician : Musician ]

  static constraints = {
    activity blank:false,size:1..100
    place blank:false,size:1..100
  }
}
