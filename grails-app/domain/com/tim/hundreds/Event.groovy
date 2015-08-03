package com.tim.hundreds

class Event {
  String uuid = TokenGenerator.generateToken()
  String activity
  String place
  Date date

  Date dateCreated
  Date lastUpdated

  static belongsTo = [ company : Company ]

  static constraints = {
    activity blank:false,size:1..100
    place blank:false,size:1..100
  }
}
