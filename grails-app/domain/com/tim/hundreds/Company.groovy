package com.tim.hundreds

class Company {
  String name
  String description
  String web

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
    address nullable:true
    social nullable:true
    datosFiscales nullable:true
  }
}
