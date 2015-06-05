package com.tim.hundreds

class Company {
  String name
  String description
  String web
  String logo
  String corporatePress
  String notes
  String tags

  Address address
  Social social
  DatosFiscales datosFiscales

  ActivityType type

  static hasMany = [
    references : Reference,
    collaborators : Collaborator,
    events : Event,
    products : Product
  ]

  static constraints = {
    name blank:false,size:1..100
    description blank:false,size:1..10000
    web nullable:true,blank:false,size:1..100
    notes nullable:true,blank:false,size:1..10000
    tags nullable:true,blank:false,size:1..10000
    logo nullable:true
    corporatePress nullable:true
    address nullable:true
    social nullable:true
    datosFiscales nullable:true
    references maxSize: ApplicationState.MAX_REFERENCES
  }
}
