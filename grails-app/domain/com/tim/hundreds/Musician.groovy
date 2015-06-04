package com.tim.hundreds

class Musician {
  String name
  String history
  String web
  String notes
  String tags
  String logoPath

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
    activities : Activity,
    telephones : Telephone,
    emails: Email
  ]

  static constraints = {
    name blank:false,size:1..100
    history blank:false,size:1..1000
    web nullable:true,blank:false,size:1..100
    notes nullable:true,blank:false,size:1..1000
    tags nullable:true,blank:false,size:1..1000
    logoPath nullable:true
    social nullable:true
    address nullable:true
    datosFiscales nullable:true
    videos maxSize: ApplicationState.MAX_VIDEOS
    photos maxSize: ApplicationState.MAX_PHOTOS
    audios maxSize: ApplicationState.MAX_AUDIOS
  }
}

