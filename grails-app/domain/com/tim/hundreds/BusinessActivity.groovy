package com.tim.hundreds

class BusinessActivity {
  String name

  static constraints = {
    name blank:false,size:1..50
  }

}
