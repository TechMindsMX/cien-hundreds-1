package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class MusicianCommand {
  String name
  String history
  String web
  String notes
  String tagsComma
  String logoPath

  Date formed

  Boolean hasManager

  Genre genre
  Social social
  Address address
  DatosFiscales datosFiscales

  static constraints = {
    tagsComma nullable:true
    importFrom Musician
  }
}

