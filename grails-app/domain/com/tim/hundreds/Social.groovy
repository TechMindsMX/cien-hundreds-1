package com.tim.hundreds

class Social {
  String facebook
  String twitter
  String googlePlus
  String instagram
  String youtube
  String linkedin
  String other

  static belongsTo = [
    musician : Musician,
    contact : Contact
  ]

  static constraints = {
    facebook nullable:true,blank:false,size:1..100
    twitter nullable:true,blank:false,size:1..100
    googlePlus nullable:true,blank:false,size:1..100
    instagram nullable:true,blank:false,size:1..100
    youtube nullable:true,blank:false,size:1..100
    linkedin nullable:true,blank:false,size:1..100
    other nullable:true,blank:false,size:1..100
  }
}
