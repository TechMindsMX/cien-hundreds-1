package com.tim.hundreds

class Social {
  String facebook
  String twitter
  String googlePlus
  String instagram
  String youtube
  String linkedin
  String other

  static belongsTo = [ musician : Musician ]

  static constraints = {
    facebook nullable:true,blank:false,size:1..255
    twitter nullable:true,blank:false,size:1..255
    googlePlus nullable:true,blank:false,size:1..255
    instagram nullable:true,blank:false,size:1..255
    youtube nullable:true,blank:false,size:1..255
    linkedin nullable:true,blank:false,size:1..255
    other nullable:true,blank:false,size:1..255
  }
}
