package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class ContactCommand {
  String firstName
  String lastName
  String motherLastName
  String other
  String nationality
  String biography
  String style
  String photoPath
  String tagsComma

  Date birthDate
  Date entryDate

  GenderType type

  RoleType role
  Social social

  static belongsTo = [
    musician : Musician
  ]

  static hasMany = [
    emails : Email,
    telephones : Telephone
  ]

  static constraints = {
    tagsComma nullable:true
    importFrom Contact
  }

}
