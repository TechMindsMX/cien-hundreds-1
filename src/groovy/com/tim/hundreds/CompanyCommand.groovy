package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class CompanyCommand {
  String name
  String description
  String web
  String logoPath
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
    notes nullable:true
    tags nullable:true,blank:false,size:1..10000
    logoPath nullable:true
    corporatePress nullable:true
    address nullable:true
    social nullable:true
    datosFiscales nullable:true
  }
}
