package com.tim.hundreds

class DataBinder {

  def static copy(def musician, def command){
    musician.name = command.name ?: musician.name
    musician.history = command.history ?: musician.history
    musician.web = command.web ?: musician.web
    musician.notes = command.notes ?: musician.notes
    musician.tagsComma = command.tagsComma ?: musician.tagsComma
    musician.formed = command.formed ?: musician.formed
    musician.hasManager = command.hasManager ?: musician.hasManager
    musician.genre = command.genre ?: musician.genre
  }

}
