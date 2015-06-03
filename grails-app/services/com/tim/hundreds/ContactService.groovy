package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class ContactService {

  def save(contactInstance, musicianId) {
    contactInstance.musician = Musician.findById(musicianId)
    contactInstance.save flush:true
  }

}
