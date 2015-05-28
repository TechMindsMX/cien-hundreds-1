package com.tim.hundreds

class Company {
  String name
  String description
  String web

  ActivityType type

  static hasMany = [
    references : Reference
  ]

  static constraints = {
    name blank:false,size:1..100
    description blank:false,size:1..1000
    web nullable:true,blank:false,size:1..100
  }
}
