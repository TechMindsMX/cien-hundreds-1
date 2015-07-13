package com.tim.hundreds

class Email {
  String uuid = TokenGenerator.generateToken()
  String address
  EmailType type

  static belongsTo = [User, Contact, Collaborator]

  static constraints = {
    address blank:false,email:true,size:6..200
  }

}
