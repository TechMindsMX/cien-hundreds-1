package com.tim.hundreds

class Telephone {
  String uuid = TokenGenerator.generateToken()
  String phone
  TelephoneType phoneType

  Date dateCreated
  Date lastUpdated

  static belongsTo = [User,Contact,Collaborator]

  static constraints = {
    phone blank:false,matches:/^[0-9]*$/,size:10..10
  }

}
