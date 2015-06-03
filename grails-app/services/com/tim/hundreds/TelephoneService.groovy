package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class TelephoneService {

  def save(telephoneInstance, contact) {
    log.info "Telephone count by contact: ${contact.telephones.size()}"
    def telephoneSize = contact.telephones.size()
    if(telephoneSize < ApplicationState.MAX_TELEPHONES){
      contact.telephones.add(telephoneInstance)
      contact.save()
    } else {
      throw new BusinessException()
    }
  }

}
