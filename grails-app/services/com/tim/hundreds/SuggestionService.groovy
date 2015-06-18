package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class SuggestionService {

  def save(suggestionInstance){
    def musician = suggestionInstance.musician
    musician.addToSuggestions(suggestionInstance)
    musician.save(failOnError:true)

    suggestionInstance
  }

}
