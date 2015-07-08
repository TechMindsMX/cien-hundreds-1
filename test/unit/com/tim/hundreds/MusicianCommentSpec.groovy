package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(MusicianComment)
class MusicianCommentSpec extends Specification {

  @Unroll
  void """When we have an musician comment with general: #general, history: #history, datosFiscales: #datosFiscales, activities: #activities, medias: #medias, notes: #notes, suggestions: #suggestions, contacts: #contacts and we send to validate we expect result: #result"""() {
  given: "We have a musiscian comment"
    def musicianComment = new MusicianComment()
  and: "A musician"
    def musician = new Musician()
    musicianComment.musician = musician
  when: "We assign values"
    musicianComment.general = general
    musicianComment.history = history
    musicianComment.datosFiscales = datosFiscales
    musicianComment.activities = activities
    musicianComment.medias = medias
    musicianComment.notes = notes
    musicianComment.suggestions = suggestions
    musicianComment.contacts = contacts
  then: "We validate musician comments"
    result == musicianComment.validate()
  where: "We have next values"
    general   | history   | datosFiscales   | activities   | medias   | notes   | suggestions   | contacts   || result
    'general' | 'history' | 'datosFiscales' | 'activities' | 'medias' | 'notes' | 'suggestions' | 'contacts' || true
  }
}
