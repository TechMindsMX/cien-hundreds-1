package com.tim.hundreds

class Email {
  String uuid = TokenGenerator.generateToken()
  String mail
  EmailType emailType

  static belongsTo = [User, Contact, Collaborator]

  static constraints = {
    mail blank:false,email:true,size:6..200
  }

}
