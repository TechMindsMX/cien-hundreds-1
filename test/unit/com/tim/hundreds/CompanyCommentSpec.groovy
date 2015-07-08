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
    'g'       | 'description' | 'datosFiscales' | 'events' | 'notes' | 'references' | 'collaborators' || true
    'general' | 'd'           | 'datosFiscales' | 'events' | 'notes' | 'references' | 'collaborators' || true
    'general' | 'description' | 'd'             | 'events' | 'notes' | 'references' | 'collaborators' || true
    'general' | 'description' | 'datosFiscales' | 'e'      | 'notes' | 'references' | 'collaborators' || true
    'general' | 'description' | 'datosFiscales' | 'events' | 'n'     | 'references' | 'collaborators' || true
    'general' | 'description' | 'datosFiscales' | 'events' | 'notes' | 'r'          | 'collaborators' || true
    'general' | 'description' | 'datosFiscales' | 'events' | 'notes' | 'references' | 'c'             || true
    null      | 'description' | 'datosFiscales' | 'events' | 'notes' | 'references' | 'collaborators' || true
    'general' | null          | 'datosFiscales' | 'events' | 'notes' | 'references' | 'collaborators' || true
    'general' | 'description' | null            | 'events' | 'notes' | 'references' | 'collaborators' || true
    'general' | 'description' | 'datosFiscales' | null     | 'notes' | 'references' | 'collaborators' || true
    'general' | 'description' | 'datosFiscales' | 'events' | null    | 'references' | 'collaborators' || true
    'general' | 'description' | 'datosFiscales' | 'events' | 'notes' | null         | 'collaborators' || true
    'general' | 'description' | 'datosFiscales' | 'events' | 'notes' | 'references' | null            || true
    ''        | 'description' | 'datosFiscales' | 'events' | 'notes' | 'references' | 'collaborators' || false
    'general' | ''            | 'datosFiscales' | 'events' | 'notes' | 'references' | 'collaborators' || false
    'general' | 'description' | ''              | 'events' | 'notes' | 'references' | 'collaborators' || false
    'general' | 'description' | 'datosFiscales' | ''       | 'notes' | 'references' | 'collaborators' || false
    'general' | 'description' | 'datosFiscales' | 'events' | ''      | 'references' | 'collaborators' || false
    'general' | 'description' | 'datosFiscales' | 'events' | 'notes' | ''           | 'collaborators' || false
    'general' | 'description' | 'datosFiscales' | 'events' | 'notes' | 'references' | ''              || false
  }
}
