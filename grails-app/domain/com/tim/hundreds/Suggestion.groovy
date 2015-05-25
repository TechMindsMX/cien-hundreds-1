package com.tim.hundreds

class Suggestion {
  String name
  String contactName
  String email
  String phone

  static belongsTo = [ musician : Musician ]

  static constraints = {
    name blank:false,size:1..100
    contactName blank:false,size:1..100
    email blank:false,email:true,unique:true,size:1..200
    phone nullable:true,blank:false,matches:/^[0-9]*$/,size:10..10
  }

}
