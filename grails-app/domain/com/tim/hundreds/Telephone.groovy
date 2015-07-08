package com.tim.hundreds

class Telephone {
  String uuid = TokenGenerator.generateToken()
  String phone
  TelephoneType type

  static belongsTo = [ contact : Contact ]

  static constraints = {
    phone nullable:true,blank:false,matches:/^[0-9]*$/,size:10..10
  }

}
