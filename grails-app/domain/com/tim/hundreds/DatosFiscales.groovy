package com.tim.hundreds

class DatosFiscales {
  String razonSocial
  String rfc
  Boolean tipoPersona

  static belongsTo = [ musician : Musician ]

  static constraints = {
    razonSocial blank:false,size:1..100
    rfc blank:false,size:1..50
  }

}
