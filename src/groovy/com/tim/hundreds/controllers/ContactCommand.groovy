package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class ContactCommand {
  String firstName
  String lastName
  String motherLastName
  String other
  String nationality
  String biography
  String style
  String photoPath
  String web
  String phone
  String phoneType
  String mail
  String emailType

  Date birthDate
  Date entryDate

  GenderType type

  MusicianRole role
  Social social

  static belongsTo = [
    musician : Musician
  ]

  static hasMany = [
    emails : Email,
    telephones : Telephone
  ]

  static constraints = {
    firstName blank:false,size:1..100
    lastName blank:false,size:1..100
    motherLastName blank:false,size:1..100
    other nullable:true,blank:false,size:1..50
    nationality nullable:true,blank:false,size:1..50
    biography nullable:true,blank:false,size:1..10000
    style nullable:true,blank:false,size:1..10000
    web nullable:true,blank:false,size:10..100,url:true
    social nullable:true
    photoPath nullable:true
    mail blank:false,email:true,size:6..200
    phone blank:false,matches:/^[0-9]*$/,size:10..10
    phoneType nullable:false
    emailType nullable:false
  }

}
