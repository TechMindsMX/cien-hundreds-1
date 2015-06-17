package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class CompanyCommand {
  String name
  String description
  String web
  String logoPath
  String corporatePress
  String notes
  String tags

  Address address
  Social social
  DatosFiscales datosFiscales
  User user

  ActivityType type

  static constraints = {
    user nullable:true
    importFrom Company
  }
}
