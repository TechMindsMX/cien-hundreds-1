package com.tim.hundreds

class Activity {
  String uuid = TokenGenerator.generateToken()
  String activity
  String place
  Date date

  Date dateCreated
  Date lastUpdated

  static belongsTo = [ musician : Musician, contact: Contact ]

  static constraints = {
    activity blank:false,size:1..100
    place blank:false,size:1..100
    musician nullable:true
    contact nullable:true
  }
}
