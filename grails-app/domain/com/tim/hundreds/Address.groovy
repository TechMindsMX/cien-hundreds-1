package com.tim.hundreds

class Address {
  String street
  String zipcode
  String neighborhood
  String town
  String state
  String country

  static belongsTo = [ musician : Musician ]

  static constraints = {
    street blank:false,size:1..200
    zipcode blank:false,size:5..5
    neighborhood blank:false,size:1..100
    town blank:false,size:1..100
    state blank:false,size:1..100
    country blank:false,size:1..100
  }
}
