package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class EventService {

  def saveEvent(eventInstance){
    log.info "Event count by company: ${Event.findByCompany(eventInstance.company)?.count()}"

    def company = eventInstance.company
    company.addToEvents(eventInstance)
    company.save(failOnError: true)

    eventInstance
  }

}
