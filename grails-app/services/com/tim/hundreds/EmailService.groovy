package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class EmailService {

  def save(emailInstance, contact){
    log.info "Emails count by contact: ${contact.emails?.size()}"

    contact.addToEmails(emailInstance)
    contact.save(failOnError: true)

    emailInstance
  }

}
