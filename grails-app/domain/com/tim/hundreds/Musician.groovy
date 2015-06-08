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
  DatosFiscales datosFiscales

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
    history blank:false,size:1..10000
    web nullable:true,blank:false,size:10..100
    notes nullable:true,blank:false,size:1..10000
    tags nullable:true,blank:false,size:1..10000
    logoPath nullable:true,blank:false,size:32..32
    social nullable:true
    address nullable:true
    datosFiscales nullable:true
    videos maxSize: ApplicationState.MAX_VIDEOS
    photos maxSize: ApplicationState.MAX_PHOTOS
    audios maxSize: ApplicationState.MAX_AUDIOS
    suggestions maxSize: ApplicationState.MAX_SUGGESTIONS
  }
}

