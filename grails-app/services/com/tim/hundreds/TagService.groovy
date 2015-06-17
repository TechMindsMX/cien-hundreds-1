package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class TagService {

  def saveMusicianTags(musicianInstance, tagsComma) {
    def tags = tagsComma?.tokenize(',')
    tags.each {
      musicianInstance.addToTags(new Tag(value:it))
    }
    musicianInstance.addToTags(new Tag(value:musicianInstance.name))
    musicianInstance.addToTags(new Tag(value:musicianInstance.genre))
  }

}
