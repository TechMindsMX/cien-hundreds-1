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

  def saveEmail(contact, email) {
    contact.addToEmails(email)
    contact.save()

    contact
  }

  def saveTelephone(contact, telephone) {
    contact.addToTelephones(telephone)
    contact.save()

    contact
  }


}
