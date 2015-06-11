package com.tim.hundreds

class Reference {
  String uuid = TokenService.generateToken()
  String name
  String contactName
  String email
  String phone

  ActivityType type

  static belongsTo = [ company : Company ]

  static constraints = {
    name blank:false,size:1..100
    contactName blank:false,size:1..100
    email blank:false,email:true,size:1..200
    phone nullable:true,blank:false,size:10..10
  }
}
