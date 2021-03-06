package com.tim.hundreds

class Collaborator {
  String uuid = TokenGenerator.generateToken()
  String firstName
  String lastName
  String motherLastName
  String position
  String notes

  Date dateCreated
  Date lastUpdated

  static belongsTo = [ company : Company ]

  static hasMany = [
    telephones : Telephone,
    emails : Email
  ]

  static constraints = {
    firstName blank:false,size:1..100
    lastName blank:false,size:1..100
    motherLastName blank:false,size:1..100
    position blank:false,size:1..100
    notes nullable:true,blank:false,size:1..10000
    telephones maxSize: ApplicationState.MAX_TELEPHONES
    emails maxSize: ApplicationState.MAX_EMAILS
  }
}
