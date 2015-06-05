package com.tim.hundreds

class Product {
  String name
  String description
  String benefits
  String target
  String competence
  String videoLink
  String discountModel
  String clients
  String distributionModel
  String salesModel
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

  static belongsTo = [
    company : Company
  ]

  static hasMany = [
    complements : Complement
  ]

  static constraints = {
    name blank:false,size:1..100
    description blank:false,size:1..10000
    benefits blank:false,size:1..10000
    target blank:false,size:1..10000
    competence blank:false,size:1..10000
    videoLink blank:false,size:1..100
    discountModel nullable:true,blank:false,size:1..10000
    clients blank:false,size:1..10000
    distributionModel nullable:true,blank:false,size:1..10000
    salesModel nullable:true,blank:false,size:1..10000
    customerModel blank:false,size:1..10000
    postSaleModel nullable:true,blank:false,size:1..10000
    notes nullable:true,blank:false,size:1..10000
    webDescription blank:false,size:1..10000
    telephoneDescription blank:false,size:1..10000
    campaingDescription blank:false,size:1..10000
    eventDescription blank:false,size:1..10000
    otherDescription blank:false,size:1..10000
  }
}
