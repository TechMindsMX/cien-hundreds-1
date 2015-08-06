package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class PhotoCommand {
  String uuid
  String path

  String musician
  String contact

  static constraints = {
    path nullable:true
    musician nullable:true
    contact nullable:true
  }
}
