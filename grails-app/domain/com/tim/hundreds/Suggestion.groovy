package com.tim.hundreds

class Suggestion {
  String uuid = TokenGenerator.generateToken()
  String name
  String contactName
  String email
  String phone

  Date dateCreated
  Date lastUpdated

  static belongsTo = [ musician : Musician ]

  static constraints = {
    name blank:false,size:1..100
    contactName blank:false,size:1..100
    email blank:false,email:true,size:1..200
    phone blank:false,matches:/^[0-9]*$/,size:10..10
  }

}
