package com.tim.hundreds

class Telephone {

  String phone
  TelephoneType type

  static constraints = {
    phone nullable:true,blank:false,size:10..10
  }

}
