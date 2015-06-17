package com.tim.hundreds

class Profile {
  String uuid = TokenService.generateToken()
  String email
  String firstName
  String middleName
  String lastName
  String phone
  String role
  String photoPath
  String resumePath

  static transients = ['role']
  static belongsTo = [User]

  static constraints = {
    email blank:false,email:true,unique:true,size:6..200
    firstName blank:false,size:1..100
    middleName blank:false,size:1..100
    lastName blank:false,size:1..100
    phone nullable:true,blank:false,matches:/^[0-9]*$/,size:10..10
    role nullable:true
    photoPath nullable:true
    resumePath nullable:true
  }
}
