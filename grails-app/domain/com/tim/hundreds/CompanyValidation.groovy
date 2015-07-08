package com.tim.hundreds

class CompanyValidation {
  String uuid = TokenGenerator.generateToken()
  String message
  ValidationType type

  static belongsTo = [
    user: User,
    company: Company
  ]

  static constraints = {
    message nullable:true,blank:false,size:1..10000
  }

}
