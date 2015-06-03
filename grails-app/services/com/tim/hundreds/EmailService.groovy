package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class EmailService {

  def save(emailInstance, contact){
    log.info "Emails count by contact: ${contact.emails.size()}"
    def emailSize = contact.emails.size()
    if(emailSize < ApplicationState.MAX_EMAILS){
      contact.emails.add(emailInstance)
      contact.save()
    } else {
      throw new BusinessException()
    }
  }

}
