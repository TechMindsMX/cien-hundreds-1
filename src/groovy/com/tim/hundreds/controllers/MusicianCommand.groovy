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
  DatosFiscales datosFiscales

  static constraints = {
    tags nullable:true
    importFrom Musician
  }
}

