package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class DatosFiscalesService {

  def saveDatosFiscalesToInstance(datosFiscalesInstance, instance){
    datosFiscalesInstance.save flush: true
    instance.datosFiscales = datosFiscalesInstance
    instance.save()
  }

}
