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

  static belongsTo = [ musician : Musician ]

  static mapping = {
    description type:'text'
    general type:'text'
    history type:'text'
    datosFiscales type:'text'
    activities type:'text'
    medias type:'text'
    notes type:'text'
    suggestions type:'text'
    contacts type:'text'
  }

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
