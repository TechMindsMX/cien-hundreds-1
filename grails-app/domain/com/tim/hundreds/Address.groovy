package com.tim.hundreds

class Address {
  String uuid = TokenGenerator.generateToken()
  String street
  String zipcode
  String neighborhood
  String county
  String town
  String state
  String country

  Date dateCreated
  Date lastUpdated

  static belongsTo = [ musician: Musician, company: Company, contact: Contact, datosFiscales: DatosFiscales ]

  static constraints = {
    street blank:false,size:1..200
    zipcode blank:false,size:5..5
    neighborhood blank:false,size:1..100
    county nullable: true, size: 1..100
    town blank:false,size:1..100
    state blank:false,size:1..100
    country blank:false,size:1..100
    musician nullable:true
    company nullable:true
    contact nullable:true
    datosFiscales nullable:true
  }
}
