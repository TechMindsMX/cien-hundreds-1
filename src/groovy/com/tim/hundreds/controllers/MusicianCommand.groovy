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
    activities : Activity
  ]

  static constraints = {
    importFrom Musician
  }
}

