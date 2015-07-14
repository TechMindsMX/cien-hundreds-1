package com.tim.hundreds

class CompanyComment {
  String general
  String description
  String datosFiscales
  String events
  String notes
  String refs
  String collaborators

  static belongsTo = [ company : Company ]

  static mapping = {
    general type:'text'
    description type:'text'
    datosFiscales type:'text'
    events type:'text'
    notes type:'text'
    refs type:'text'
    collaborators type:'text'
  }

  static constraints = {
    general nullable:true,blank:false,size:1..10000
    description nullable:true,blank:false,size:1..10000
    datosFiscales nullable:true,blank:false,size:1..10000
    events nullable:true,blank:false,size:1..10000
    notes nullable:true,blank:false,size:1..10000
    refs nullable:true,blank:false,size:1..10000
    collaborators nullable:true,blank:false,size:1..10000
  }

}
