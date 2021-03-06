package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class UserCommand {
  String username
  String password
  String email
  String firstName
  String lastName
  String motherLastName
  String phone
  String role
  String photoPath
  String resumePath

  Boolean status
  String terms

  String emailCheck
  String passwordCheck

  static constraints = {
    firstName blank:false,size:1..100
    lastName blank:false,size:1..100
    motherLastName blank:false,size:1..100
    phone nullable:true,blank:false,matches:/^[0-9]*$/,size:10..10
    role blank:false,size:6..20
    photoPath nullable:true
    resumePath nullable:true

    password(blank:false,size:10..50,matches:/^(?=.*\d)(?=.*[=_\-¿?¡!@#\$%^&*]+)?(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/,validator:{val, obj ->
      if(!val.equalsIgnoreCase(obj.passwordCheck)) {
        return false
      }
    })
    email(blank:false,email:true,unique:true,size:6..200,validator:{val, obj ->
      if(!val.equalsIgnoreCase(obj.emailCheck)) {
        return false
      }
    })
    username(blank:false,size:6..50,validator:{val, obj ->
      if(User.findByUsername(val)) {
        return false
      }
    })
    terms (validator:{val, obj ->
          return val == 'on'
    })

  }
}
