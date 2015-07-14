package com.tim.hundreds

class Musician {
  String uuid = TokenGenerator.generateToken()
  String name
  String history
  String web
  String notes
  String tagsComma
  String logoPath

  Date dateCreated
  Date lastUpdated
  Date formed

  Boolean hasManager
  Boolean active = false

  Genre genre
  User assigned

  static transients = ['tagsComma']

  static hasOne = [
    musicianValidation : MusicianValidation,
    musicianComment: MusicianComment,
    datosFiscales: DatosFiscales,
    address: Address,
    social: Social
  ]

  static belongsTo = [user : User]

  static hasMany = [
    photos : Photo,
    videos : Video,
    audios : Audio,
    suggestions : Suggestion,
    contacts : Contact,
    activities : Activity,
    tags : Tag
  ]

  static constraints = {
    name blank:false,size:1..100
    history blank:false,size:1..10000
    web nullable:true,blank:false,size:10..100,url:true
    notes nullable:true,blank:false,size:1..10000
    tagsComma nullable:true,blank:false,size:1..10000
    logoPath nullable:true,blank:false,size:36..36
    social nullable:true
    address nullable:true
    datosFiscales nullable:true
    musicianValidation nullable:true
    assigned nullable:true
    musicianComment nullable:true
    videos maxSize: ApplicationState.MAX_VIDEOS
    photos maxSize: ApplicationState.MAX_PHOTOS
    audios maxSize: ApplicationState.MAX_AUDIOS
    suggestions maxSize: ApplicationState.MAX_SUGGESTIONS
    contacts maxSize: ApplicationState.MAX_CONTACTS
    activities maxSize: ApplicationState.MAX_ACTIVITIES
  }
}

