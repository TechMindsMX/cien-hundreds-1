package com.tim.hundreds

class Contact {
  String firstName
  String middleName
  String lastName
  String other
  String nationality
  String biography
  String style
  String photoPath

  Date birthDate
  Date entryDate

  GenderType type

  RoleType role
  Social social
  Address address

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
    biography nullable:true,blank:false,size:1..10000
    style nullable:true,blank:false,size:1..10000
    photoPath nullable:true
    social nullable:true
    address nullable:true
    telephones maxSize: ApplicationState.MAX_TELEPHONES
    emails maxSize: ApplicationState.MAX_EMAILS
  }

}
