package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class SuggestionService {

  def save(suggestionInstance){
    log.info "Suggestion count by musician: ${Suggestion.findByMusician(suggestionInstance.musician)?.count()}"

    def musician = suggestionInstance.musician
    musician.addToSuggestions(suggestionInstance)
    musician.save(failOnError:true)

    suggestionInstance
  }

}
