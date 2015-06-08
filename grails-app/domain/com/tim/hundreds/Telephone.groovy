package com.tim.hundreds

class Telephone {

  String phone
  TelephoneType type

  static belongsTo = [Contact]

  static constraints = {
    phone nullable:true,blank:false,size:10..10
  }

}
