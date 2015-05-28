package com.tim.hundreds

class Contact {
  String firstName
  String middleName
  String lastName
  String other
  String nationality
  String biography
  String style

  Date birthDate
  Date entryDate

  RoleType role
  Social social

  static belongsTo = [ musician : Musician ]

  static hasMany = [
    emails : Email,
    telephones : Telephone
  ]

  static constraints = {
    firstName blank:false,size:1..100
    middleName blank:false,size:1..100
    lastName blank:false,size:1..100
    other nullable:true,blank:false,size:1..50
    nationality nullable:true,blank:false,size:1..50
    biography nullable:true,blank:false,size:1..1000
    style nullable:true,blank:false,size:1..1000
    social nullable:true
  }

}
