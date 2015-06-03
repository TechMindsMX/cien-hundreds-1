package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class SuggestionService {

  def save(suggestionInstance){
    log.info "Suggestion count by musician: ${Suggestion.findByMusician(suggestionInstance.musician)?.count()}"
    def suggestionSize = Suggestion.findByMusician(suggestionInstance.musician)?.count()
    if(suggestionSize < ApplicationState.MAX_SUGGESTION){
      suggestionInstance.save flush:true
    } else {
        throw new BusinessException()
    }
  }

}
