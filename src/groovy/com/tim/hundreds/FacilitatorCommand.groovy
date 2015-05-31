package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class FacilitatorCommand {
  String username
  String password
  String email
  String firstName
  String middleName
  String lastName
  String role

  String passwordCheck

  static constraints = {
    firstName blank:false,size:1..100
    middleName blank:false,size:1..100
    lastName blank:false,size:1..100

    password(blank:false,size:10..50,matches:/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{10,}$/,validator:{val, obj ->
      if(!val.equalsIgnoreCase(obj.passwordCheck)) {
        return false
      }
    })
    username(blank:false,size:3..50,validator:{val, obj ->
      if(User.findByUsername(val)) {
        return false
      }
    })

  }
}
