package com.tim.hundreds

class Telephone {
  String uuid = TokenService.generateToken()
  String phone
  TelephoneType type

  static belongsTo = [User,Contact]

  static constraints = {
    phone nullable:true,blank:false,matches:/^[0-9]*$/,size:10..10
  }

}
