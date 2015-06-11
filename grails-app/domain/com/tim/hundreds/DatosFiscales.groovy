package com.tim.hundreds

class DatosFiscales {
  String uuid = TokenService.generateToken()
  String razonSocial
  String rfc
  Boolean personaMoral
  Boolean personaFisica

  Address address

  static constraints = {
    razonSocial blank:false,size:1..100
    rfc blank:false,size:10..50
    address nullable:true
    personaMoral nullable:true
    personaFisica nullable:true
  }

}
