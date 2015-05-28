package com.tim.hundreds

class Musician {
  String name
  String history
  String web
  String notes

  Date dateCreated
  Date lastUpdated
  Date formed

  Boolean hasManager

  Genre genre
  Social social
  Address address

  static hasOne = [
    datosFiscales : DatosFiscales
  ]

  static hasMany = [
    photos : Photo,
    videos : Video,
    audios : Audio,
    suggestions : Suggestion,
    contacts : Contact,
    activities : Activity
  ]

  static constraints = {
    name blank:false,size:1..100
    history blank:false,size:1..1000
    web nullable:true,blank:false,size:1..100
    notes nullable:true,blank:false,size:1..1000
    social nullable:true
    address nullable:true
    datosFiscales nullable:true
  }
}

