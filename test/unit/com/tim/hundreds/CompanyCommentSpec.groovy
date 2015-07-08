package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(CompanyComment)
class CompanyCommentSpec extends Specification {

  @Unroll
  void """When we have a company comment with general: #general, description: #description, datosFiscales: #datosFiscales, events: #events, notes: #notes, references: #references, collaborators: #collaborators and we validate we expect result: #result"""() {
  given:"An Company comment"
    def companyComment = new CompanyComment()
  and:"A company"
    def company = new Company()
    companyComment.company = company
  when:"We assign values"
    companyComment.general = general
    companyComment.description = description
    companyComment.datosFiscales = datosFiscales
    companyComment.events = events
    companyComment.notes = notes
    companyComment.references = references
    companyComment.collaborators = collaborators
  then:"We validate"
    result == companyComment.validate()
  where:"We have next values"
    general   | description   | datosFiscales   | events   | notes   | references   | collaborators   || result
    'general' | 'description' | 'datosFiscales' | 'events' | 'notes' | 'references' | 'collaborators' || true
  }
}
