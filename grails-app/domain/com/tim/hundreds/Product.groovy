package com.tim.hundreds

class Product {
  String uuid = TokenGenerator.generateToken()
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

  Boolean campaign
  String campaignDescription

  Boolean event
  String eventDescription

  Boolean other
  String otherDescription

  Date dateCreated
  Date lastUpdated

  static hasOne = [ 
    productComment: ProductComment
  ]

  static belongsTo = [
    company : Company
  ]

  static hasMany = [
    complements : Complement
  ]

  static mapping = {
    description type:'text'
    benefits type:'text'
    target type:'text'
    competence type:'text'
    discountModel type:'text'
    clients type:'text'
    distributionModel type:'text'
    salesModel type:'text'
    customerModel type:'text'
    postSaleModel type:'text'
    notes type:'text'
    webDescription type:'text'
    telephoneDescription type:'text'
    campaignDescription type:'text'
    eventDescription type:'text'
    otherDescription type:'text'
  }

  static constraints = {
    name blank:false,size:1..100
    description blank:false,size:1..10000
    benefits blank:false,size:1..10000
    target blank:false,size:1..10000
    competence blank:false,size:1..10000
    videoLink blank:false,size:10..100,url:true, validator: {val,obj -> 
        if (val ==~ /(?:[hH][tT]{2}[pP][sS]{0,1}:\/\/)?[wW]{0,3}\.{0,1}[yY][oO][uU][tT][uU](?:\.[bB][eE]|[bB][eE]\.[cC][oO][mM])\S+/) {
          return true
        } else if (val ==~ /https?:\/\/(?:www\.)?(vimeo|youtube)\.com\/\S+/){
          return true
        }
         else {
          return false
        }
      }
    discountModel nullable:true,blank:false,size:1..10000
    clients blank:false,size:1..10000
    distributionModel nullable:true,blank:false,size:1..10000
    salesModel nullable:true,blank:false,size:1..10000
    customerModel blank:false,size:1..10000
    postSaleModel nullable:true,blank:false,size:1..10000
    notes nullable:true,blank:false,size:1..10000
    webDescription nullable:true,blank:false,size:1..10000
    telephoneDescription nullable:true,blank:false,size:1..10000
    campaignDescription nullable:true,blank:false,size:1..10000
    eventDescription nullable:true,blank:false,size:1..10000
    otherDescription nullable:true,blank:false,size:1..10000
    productComment nullable:true
    complements maxSize: ApplicationState.MAX_COMPLEMENTS
  }
}
