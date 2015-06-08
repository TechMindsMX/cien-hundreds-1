package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class ContactService {

  def save(contactInstance) {
    log.info "Contact by musician: ${Contact.findByMusician(contactInstance.musician)?.count()}"

    def musician = contactInstance.musician
    musician.addToContacts(contactInstance)
    musician.save(failOnError: true)

    contactInstance
  }

}
