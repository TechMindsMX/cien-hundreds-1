package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class CollaboratorService {

  def save(collaboratorInstance) {
    log.info "Collaborator by company: ${Collaborator.findByCompany(collaboratorInstance.company)?.count()}"

    def company = collaboratorInstance.company
    company.addToCollaborators(collaboratorInstance)
    company.save(failOnError: true)

    collaboratorInstance
  }

}
