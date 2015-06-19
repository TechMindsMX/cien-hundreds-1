package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class UserCommand {
  String username
  String password
  String email
  String firstName
  String middleName
  String lastName
  String phone
  String role
  String photoPath
  String resumePath

  String emailCheck
  String passwordCheck

  static constraints = {
    firstName blank:false,size:1..100
    middleName blank:false,size:1..100
    lastName blank:false,size:1..100
    email blank:false,email:true,unique:true,size:1..200
    phone nullable:true,blank:false,matches:/^[0-9]*$/,size:10..10
    role blank:false,size:6..20
    photoPath nullable:true
    resumePath nullable:true

    password(blank:false,size:10..50,matches:/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{10,}$/,validator:{val, obj ->
      if(!val.equalsIgnoreCase(obj.passwordCheck)) {
        return false
      }
    })
    username(blank:false,size:6..50,validator:{val, obj ->
      if(User.findByUsername(val)) {
        return false
      }
    })

  }
}
