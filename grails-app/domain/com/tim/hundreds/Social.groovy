package com.tim.hundreds

class Social {
  String uuid = TokenGenerator.generateToken()
  String facebook
  String twitter
  String googlePlus
  String instagram
  String youtube
  String linkedin
  String other

  Date dateCreated
  Date lastUpdated

  static belongsTo = [ musician: Musician, company: Company, contact: Contact ]

  static constraints = {
    facebook nullable:true,blank:false,size:10..100,url: true
    twitter nullable:true,blank:false,size:10..100,url: true
    googlePlus nullable:true,blank:false,size:10..100,url: true
    instagram nullable:true,blank:false,size:10..100,url: true
    youtube nullable:true,blank:false,size:10..100,url: true
    linkedin nullable:true,blank:false,size:10..100,url: true
    other nullable:true,blank:false,size:10..100
    musician nullable:true
    company nullable:true
    contact nullable:true
  }
}
