package com.tim.hundreds



class Company {
  String uuid = TokenService.generateToken()
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

  static belongsTo = [user : User]

  static hasMany = [
    references : Reference,
    collaborators : Collaborator,
    events : Event,
    products : Product
  ]

  static constraints = {
    name blank:false,size:1..100
    description blank:false,size:1..10000
    web nullable:true,blank:false,size:1..100,url:true
    notes nullable:true,blank:false,size:1..10000
    tags nullable:true,blank:false,size:1..10000
    logo nullable:true
    corporatePress nullable:true
    address nullable:true
    social nullable:true
    datosFiscales nullable:true
    references maxSize: ApplicationState.MAX_REFERENCES
    events maxSize: ApplicationState.MAX_EVENTS
    collaborators maxSize: ApplicationState.MAX_COLLABORATORS
    products maxSize: ApplicationState.MAX_PRODUCTS
  }
}
