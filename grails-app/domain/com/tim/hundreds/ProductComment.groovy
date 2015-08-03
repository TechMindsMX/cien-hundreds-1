package com.tim.hundreds

class ProductComment {
  String general
  String description
  String benefits
  String target
  String competence
  String discountModel
  String distributionModel
  String customerModel
  String notes

  Date dateCreated
  Date lastUpdated

  static belongsTo = [ product : Product ]

  static mapping = {
    general type:'text'
    description type:'text'
    benefits type:'text'
    target type:'text'
    competence type:'text'
    discountModel type:'text'
    distributionModel type:'text'
    customerModel type:'text'
    notes type:'text'
  }

  static constraints = {
    general nullable:true,blank:false,size:1..10000
    description nullable:true,blank:false,size:1..10000
    benefits nullable:true,blank:false,size:1..10000
    target nullable:true,blank:false,size:1..10000
    competence nullable:true,blank:false,size:1..10000
    discountModel nullable:true,blank:false,size:1..10000
    distributionModel nullable:true,blank:false,size:1..10000
    customerModel nullable:true,blank:false,size:1..10000
    notes nullable:true,blank:false,size:1..10000
  }

}
