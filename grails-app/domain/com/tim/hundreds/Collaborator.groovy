package com.tim.hundreds

class Collaborator {
  String firstName
  String middleName
  String lastName
  String position
  String notes

  static belongsTo = [ company : Company ]

  static hasMany = [
    emails : Email,
    telephones : Telephone
  ]

  static constraints = {
    firstName blank:false,size:1..100
    middleName blank:false,size:1..100
    lastName blank:false,size:1..100
    lastName blank:false,size:1..100
    notes nullable:true,blank:false,size:1..1000
  }
}
