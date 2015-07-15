package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class MusicianCommand {
  Long id
  String uuid
  String name
  String history
  String web
  String notes
  String tagsComma
  String logoPath

  Date formed

  Boolean hasManager
  Boolean active = true

  Genre genre
  Social social
  Address address
  DatosFiscales datosFiscales
  MusicianValidation musicianValidation
  User user
  User assigned

  static constraints = {
    tagsComma nullable:true
    user nullable:true
    musicianValidation nullable:true
    formed(validator: {val, obj ->
       val?.before(new Date())
    })
    importFrom Musician
  }
}

