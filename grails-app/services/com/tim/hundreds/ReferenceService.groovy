package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class ReferenceService {

  def saveReference(referenceInstance){
    log.info "Reference count by company: ${Reference.findByCompany(referenceInstance.company)?.count()}"

    def company = referenceInstance.company
    company.addToReferences(referenceInstance)
    company.save(failOnError:true)

    referenceInstance
  }

}
