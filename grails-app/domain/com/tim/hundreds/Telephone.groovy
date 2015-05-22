package com.tim.hundreds

class Telephone {

  String phone
  TelephoneType type

  static belongsTo = [ suggesion : Suggestion ]

  static constraints = {
    phone nullable:true,blank:false,matches:/^[0-9]*$/,size:10..10
  }

}
