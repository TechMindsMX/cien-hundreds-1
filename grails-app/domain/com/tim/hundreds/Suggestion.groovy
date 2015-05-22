package com.tim.hundreds

class Suggestion {

  String name
  String contactName
  String email

  Telephone telephone

  static hasOne = [ telephone : Telephone ]
  static belongsTo = [ musician : Musician ]

  static constraints = {
    name blank:false,size:1..100
    contactName blank:false,size:1..100
    email blank:false,email:true,unique:true,size:1..200
    telephone nullable:true
  }

}
