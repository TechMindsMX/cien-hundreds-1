package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class EmailService {

  def save(emailInstance, instance){
    instance.addToEmails(emailInstance)
    instance.save(failOnError: true)

    emailInstance
  }

}
