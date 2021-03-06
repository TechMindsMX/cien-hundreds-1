package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class CompanyCommand {
  String uuid
  String name
  String description
  String web
  String logoPath
  String corporatePressPath
  String notes
  String tagsComma

  Address address
  Social social
  DatosFiscales datosFiscales
  BusinessActivity type

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
    tagsComma nullable:true,blank:false,size:1..10000
    logoPath nullable:true,blank:false,size:36..36
    corporatePressPath nullable:true,blank:false,size:36..36
    address nullable:true
    social nullable:true
    datosFiscales nullable:true
  }
}
