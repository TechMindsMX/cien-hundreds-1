package com.tim.hundreds

class DatosFiscales {
  String razonSocial
  String rfc
  Boolean personaMoral
  Boolean personaFisica

  Address address

  static constraints = {
    razonSocial blank:false,size:1..100
    rfc blank:false,size:1..50
    address nullable:true
    personaMoral nullable:true
    personaFisica nullable:true
  }

}
