package com.tim.hundreds

class Email {
  String address
  EmailType type

  static belongsTo = [ contact : Contact ]

  static constraints = {
    address blank:false,email:true,unique:true,size:1..200
  }

}
