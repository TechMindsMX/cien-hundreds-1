package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class EmailService {

  def save(emailInstance){
    def contact = emailInstance.contact
    contact.addToEmails(emailInstance)
    contact.save(failOnError: true)

    emailInstance
  }

}
