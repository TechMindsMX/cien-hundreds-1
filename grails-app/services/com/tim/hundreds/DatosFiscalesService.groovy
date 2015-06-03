package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class DatosFiscalesService {

  def save(datosFiscalesInstance, musicianId){
    datosFiscalesInstance.save flush:true
    def musician = Musician.findById(musicianId)
    musician.datosFiscales = datosFiscalesInstance
    musician.save()
  }

}
