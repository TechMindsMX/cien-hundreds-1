package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class CompanyCommand {
  String name
  String description
  String web
  String corporatePressPath
  String notes
  String tags

  Address address
  Social social
  DatosFiscales datosFiscales

  ActivityType type

  String logoPath

  static hasMany = [
    references : Reference,
    collaborators : Collaborator,
    events : Event,
    products : Product
  ]

  static constraints = {
    name blank:false,size:1..100
    description blank:false,size:1..10000
    web nullable:true,blank:false,size:10..100,url:true
    notes nullable:true,blank:false,size:1..10000
    tags nullable:true,blank:false,size:1..10000
    logoPath nullable:true,blank:false,size:36..36
    corporatePressPath nullable:true,blank:false,size:36..36
    address nullable:true
    social nullable:true
    datosFiscales nullable:true
  }
}
