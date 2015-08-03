package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class FinderService {

  def findMusician(musicianInstance, params) {
    Musician.findByUuid(params.musicianUuid) ?: Musician.findByUuid(musicianInstance.uuid)
  }

}
