package com.tim.hundreds

import org.grails.taggable.*

class Company implements Taggable {
  String uuid = TokenGenerator.generateToken()
  String name
  String description
  String web
  String logoPath
  String corporatePressPath
  String notes
  String tagsComma

  Boolean active = false

  BusinessActivity type
  DatosFiscales datosFiscales
  Address address
  Social social
  User assigned

  Date dateCreated
  Date lastUpdated

  static transients = ['tagsComma']

  static hasOne = [
    companyValidation : CompanyValidation,
    companyComment: CompanyComment
  ]

  Date dateCreated
  Date lastUpdated

  static belongsTo = [user : User]

  static hasMany = [
    references : Reference,
    collaborators : Collaborator,
    events : Event,
    products : Product
  ]

  static mapping = {
    description type:'text'
    notes type:'text'
    tags type:'text'
  }

  static constraints = {
    name blank:false,size:1..100
    description blank:false,size:1..10000
    web nullable:true,blank:false,size:1..100,url:true
    notes nullable:true,blank:false,size:1..10000
    tagsComma nullable:true,blank:false,size:1..10000
    logoPath nullable:true
    corporatePressPath nullable:true
    address nullable:true
    social nullable:true
    datosFiscales nullable:true
    companyValidation nullable:true
    assigned nullable:true
    companyComment nullable:true
    references maxSize: ApplicationState.MAX_REFERENCES
    events maxSize: ApplicationState.MAX_EVENTS
    collaborators maxSize: ApplicationState.MAX_COLLABORATORS
    products maxSize: ApplicationState.MAX_PRODUCTS
  }
}
