package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class TagService {

  def saveMusicianTags(musicianInstance) {
    musicianInstance.addToTags(new Tag(value:musicianInstance.name))
    musicianInstance.addToTags(new Tag(value:musicianInstance.genre))
  }

}
