package com.tim.hundreds

class Product {
  String name
  String description
  String benefits
  String target
  String competence
  String salesModel
  String clients
  String distributionModel
  String customerModel
  String postSaleModel
  String notes

  Boolean web
  String webDescription

  Boolean telephone
  String telephoneDescription

  Boolean campaing
  String campaingDescription

  Boolean event
  String eventDescription

  Boolean other
  String otherDescription

  static hasMany = [
    videos : Video,
  ]

  static constraints = {
    name blank:false,size:1..100
    description blank:false,size:1..10000
    distributionModel nullable:true,blank:false,size:1..10000
  }
}
