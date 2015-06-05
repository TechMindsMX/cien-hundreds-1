package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class CompanyCommand {
  String name
  String description
  String web
  String logoPath

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
    logoPath nullable:true
    address nullable:true
    social nullable:true
    datosFiscales nullable:true
  }
}
