package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class TagService {

  def addMusicianTags(musicianInstance, tagsComma) {
    def tags = tagsComma?.tokenize(',')
    tags.each {
      if(it != 'null'){
          it = it.replaceAll('\\[','')
          it = it.replaceAll('\\]','')
          musicianInstance.addToTags(new Tag(value:it))
      }
    }
  }

}
