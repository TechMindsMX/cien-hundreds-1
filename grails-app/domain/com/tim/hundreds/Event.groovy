package com.tim.hundreds

class Event {
  String place
  Date date

  static belongsTo = [ company : Company ]

  static constraints = {
    activity blank:false,size:1..100
    place blank:false,size:1..100
  }
}
