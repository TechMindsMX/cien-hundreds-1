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

  Role role
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
    social nullable:true
  }

}
