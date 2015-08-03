package com.tim.hundreds

class Reference {
  String uuid = TokenGenerator.generateToken()
  String name
  String contactName
  String email
  String phone

  BusinessActivity type

  Date dateCreated
  Date lastUpdated

  static belongsTo = [ company : Company ]

  static constraints = {
    name blank:false,size:1..100
    contactName blank:false,size:1..100
    email blank:false,email:true,size:1..200
    phone nullable:true,blank:false,size:10..10
  }
}
