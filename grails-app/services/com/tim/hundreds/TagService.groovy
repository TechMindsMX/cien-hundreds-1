package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class TagService {

  def addTags(def target, String tagsComma) {
    def tags = tagsComma?.tokenize(',')
    tags.each {
      if(it != 'null' && !target.tags.contains(it.trim())){
        target.addTag(it.trim())
      }
    }

    target.save()
  }

  def deleteTags(def target){
    target.setTags([])
    target.save()
  }

}
