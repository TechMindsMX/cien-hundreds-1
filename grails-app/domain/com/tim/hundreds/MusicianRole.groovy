package com.tim.hundreds

class MusicianRole {
  String name

  Date dateCreated
  Date lastUpdated

  static constraints = {
    name blank:false,size:1..50
  }

}
