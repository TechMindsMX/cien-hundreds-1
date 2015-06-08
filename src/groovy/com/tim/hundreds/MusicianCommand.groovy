package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class MusicianCommand {
  String name
  String history
  String web
  String notes
  String tags
  String logoPath

  Date formed

  Boolean hasManager

  Genre genre
  Social social
  Address address

  def datosFiscales

  static hasMany = [
    photos : Photo,
    videos : Video,
    audios : Audio,
    suggestions : Suggestion,
    contacts : Contact,
    activities : Activity,
    telephones : Telephone,
    emails: Email
  ]

  static constraints = {
    name blank:false,size:1..100
    history blank:false,size:1..10000
    web nullable:true,blank:false,size:10..100
    notes nullable:true,blank:false,size:1..10000
    tags nullable:true,blank:false,size:1..10000
    logoPath nullable:true,blank:false,size:32..32
    social nullable:true
    address nullable:true
    datosFiscales nullable:true
  }
}

