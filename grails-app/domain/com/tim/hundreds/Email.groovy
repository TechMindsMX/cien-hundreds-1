package com.tim.hundreds

class Email {
  String uuid = TokenService.generateToken()
  String address
  EmailType type

  static belongsTo = [User,Contact]

  static constraints = {
    address blank:false,email:true,size:6..200
  }

}
