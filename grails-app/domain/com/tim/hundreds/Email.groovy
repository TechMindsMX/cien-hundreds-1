package com.tim.hundreds

class Email {
  String address
  EmailType type

  static constraints = {
    address blank:false,email:true,size:1..200
  }

}
