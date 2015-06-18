package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class TagService {

  def addMusicianTags(musicianInstance, tagsComma) {
    def tags = tagsComma?.tokenize(',')
    tags.each {
      musicianInstance.addToTags(new Tag(value:it))
    }
  }

}