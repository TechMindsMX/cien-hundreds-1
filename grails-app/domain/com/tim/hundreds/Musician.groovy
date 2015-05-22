package com.tim.hundreds

class Musician {
  String name
  String history
  String web

  Date dateCreated
  Date lastUpdated
  Date formed

  Boolean hasManager

  Social social
  static hasOne = [ social : Social ]

  static hasMany = [
    photos : Photo,
    videos : Video,
    audios : Audio
  ]

  static constraints = {
    name blank:false,size:1..100
    history blank:false,size:1..1000
    web nullable:true,blank:false,size:1..100
    social nullable:true
  }

}

