package com.tim.hundreds

class DatosFiscales {
  String uuid = TokenGenerator.generateToken()
  String razonSocial
  String rfc

  PersonaJuridicaType personaJuridica

  static hasOne = [
    address: Address
  ]

  static belongsTo = [
    musician: Musician,
    company: Company
  ]

  static constraints = {
    razonSocial blank:false,size:1..100
    rfc(blank:false,size:10..50,validator: { val, obj ->
        if(obj.personaJuridica == PersonaJuridicaType.FISICA && !(val ==~ /^[A-Z]{4}([0-9]{2})(1[0-2]|0[1-9])([0-3][0-9])([A-Z0-9]{3})$/) ) {
          return false
        } else if (obj.personaJuridica == PersonaJuridicaType.MORAL && !(val ==~ /^[A-Z]{3}([0-9]{2})(1[0-2]|0[1-9])([0-3][0-9])([A-Z0-9]{3})$/) ) {
          return false
        }
      })
    address nullable:true
  }

}
