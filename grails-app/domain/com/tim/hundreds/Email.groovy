package com.tim.hundreds

class Email {
  String address
  EmailType type

  static belongsTo = [Contact]

  static constraints = {
    address blank:false,email:true,size:6..200
  }

}
