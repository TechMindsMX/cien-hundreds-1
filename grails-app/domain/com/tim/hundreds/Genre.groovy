package com.tim.hundreds

class Genre {
  String name
  Boolean enabled = true

  Date dateCreated
  Date lastUpdated

  static belongsTo = [Musician]

  static constraints = {
    name blank:false,size:1..50
  }
}
