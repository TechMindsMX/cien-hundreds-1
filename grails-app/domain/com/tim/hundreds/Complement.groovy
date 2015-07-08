package com.tim.hundreds

class Complement {
  String uuid = TokenGenerator.generateToken()
  String name
  BigDecimal price

  static belongsTo = [
    product : Product
  ]

  static constraints = {
    name blank:false,size:1..100
    price blank:false,min:0.01
  }
}
