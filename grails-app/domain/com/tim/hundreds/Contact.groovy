package com.tim.hundreds

class Contact {
  String firstName
  String middleName
  String lastName

  Role role

  static hasMany = [
    emails : Email,
    telephones : Telephone
  ]

  static constraints = {


  }

}
