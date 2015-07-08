package com.tim.hundreds

class UserTelephone {
  String uuid = TokenGenerator.generateToken()
  String phone
  TelephoneType type

  static belongsTo = [ user : User ]

  static constraints = {
    phone nullable:true,blank:false,matches:/^[0-9]*$/,size:10..10
  }

}
