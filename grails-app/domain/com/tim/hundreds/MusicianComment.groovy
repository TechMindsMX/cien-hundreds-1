package com.tim.hundreds

class MusicianComment {
  String general
  String history
  String datosFiscales
  String activities
  String medias
  String notes
  String suggestions
  String contacts

  static constraints = {
    general nullable:true,blank:false,size:1..10000
    history nullable:true,blank:false,size:1..10000
    datosFiscales nullable:true,blank:false,size:1..10000
    activities nullable:true,blank:false,size:1..10000
    medias nullable:true,blank:false,size:1..10000
    notes nullable:true,blank:false,size:1..10000
    suggestions nullable:true,blank:false,size:1..10000
    contacts nullable:true,blank:false,size:1..10000
  }

}
