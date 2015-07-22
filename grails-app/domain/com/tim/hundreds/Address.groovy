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

  static belongsTo = [ musician: Musician, company: Company, contact: Contact, datosFiscales: DatosFiscales ]

  static constraints = {
    street blank:false,size:1..200
    zipcode blank:false,size:5..5
    neighborhood blank:false,size:1..100
    county nullable: true, size: 1..100
    town blank:false,size:1..100
    state blank:false,size:1..100
    country blank:false,size:1..100
    musician nullable:true, validator: {val, obj->  if (!val && !obj.company && !obj.contact && !obj.datosFiscales) return 'default.association.mustbeone'}
    company nullable:true, validator: {val, obj->  if (!val && !obj.musician && !obj.contact && !obj.datosFiscales) return 'default.association.mustbeone'}
    contact nullable:true, validator: {val, obj->  if (!val && !obj.musician && !obj.company && !obj.datosFiscales) return 'default.association.mustbeone'}
    datosFiscales nullable:true, validator: {val, obj->  if (!val && !obj.musician && !obj.company && !obj.contact) return 'default.association.mustbeone'}
  }
}
