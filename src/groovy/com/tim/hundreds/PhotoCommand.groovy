package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class PhotoCommand {
  String path

  Musician musician

  static constraints = {
    path nullable:true
  }
}
