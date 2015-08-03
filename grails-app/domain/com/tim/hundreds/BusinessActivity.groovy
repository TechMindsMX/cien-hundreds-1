package com.tim.hundreds

class BusinessActivity {
  String name

  Date dateCreated
  Date lastUpdated

  static constraints = {
    name blank:false,size:1..50
  }

}
