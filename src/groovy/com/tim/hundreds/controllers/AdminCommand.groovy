package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class AdminCommand {

  String role
  String username
  String firstName
  String lastName
  String motherLastName
  String phone
  Boolean status
  String terms
  String email
  String emailCheck
  String photoPath
  String resumePath

  static constraints = {
    username blank: false
    email nullable:false,email:true,size:6..200
    emailCheck nullable:false,email:true,size:6..200
    firstName blank:false,size:1..100
    motherLastName blank:false,size:1..100
    lastName blank:false,size:1..100
    phone nullable:true,blank:false,matches:/^[0-9]*$/,size:10..10
    role nullable:true
    photoPath nullable:true
    resumePath nullable:true
  }

}