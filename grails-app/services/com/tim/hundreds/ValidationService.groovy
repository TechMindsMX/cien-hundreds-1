package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class ValidationService {

  def validate(musicianValidationInstance) {
    def musician = musicianValidationInstance.musician
    def active = musicianValidationInstance.type == ValidationType.ACCEPTED ? true : false
    musician.active = active
    if(active){

    }

  }

}
