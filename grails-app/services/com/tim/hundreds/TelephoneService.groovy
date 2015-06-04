package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class TelephoneService {

  def save(telephoneInstance, contact) {
    log.info "Telephone count by contact: ${contact.telephones.size()}"

    contact.addToTelephones(telephoneInstance)
    contact.save(failOnError:true)
    telephoneInstance
  }

}
