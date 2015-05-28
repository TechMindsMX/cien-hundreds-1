package com.tim.hundreds

class Company {
  String name
  String description
  String web

  Address address
  Social social

  ActivityType type

  static hasMany = [
    references : Reference,
    events : Event
  ]

  static constraints = {
    name blank:false,size:1..100
    description blank:false,size:1..1000
    web nullable:true,blank:false,size:1..100
    address nullable:true
    social nullable:true
  }
}
