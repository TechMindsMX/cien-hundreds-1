package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class PhotoCommand {
  String uuid
  String path

  Musician musician

  static constraints = {
    path nullable:true
  }
}
