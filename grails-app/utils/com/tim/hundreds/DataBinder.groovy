package com.tim.hundreds

class DataBinder {

  def static copy(Musician musician, MusicianCommand command){
    musician.name = command.name ?: musician.name
    musician.history = command.history ?: musician.history
    musician.web = command.web ?: musician.web
    musician.notes = command.notes ?: musician.notes
    musician.tagsComma = command.tagsComma ?: musician.tagsComma
    musician.formed = command.formed ?: musician.formed
    musician.hasManager = command.hasManager ?: musician.hasManager
    musician.genre = command.genre ?: musician.genre
    musician.logoPath = command.logoPath ?: musician.logoPath
  }

  def static copy(Company company, CompanyCommand command){
    company.name = command.name ?: company.name
    company.description = command.description ?: company.description
    company.web = command.web ?: company.web
    company.notes = command.notes ?: company.notes
    company.tagsComma = command.tagsComma ?: company.tagsComma
    company.logoPath = command.logoPath ?: company.logoPath
    company.corporatePressPath = command.corporatePressPath ?: company.corporatePressPath
  }

}
