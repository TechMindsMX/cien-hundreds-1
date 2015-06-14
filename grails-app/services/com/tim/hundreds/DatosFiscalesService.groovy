package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class DatosFiscalesService {

  def saveDatosFiscalesToInstance(datosFiscalesInstance, instance){
    datosFiscalesInstance.save flush: true
    instance.datosFiscales = datosFiscalesInstance
    instance.save()

    instance
  }

  def deleteDatosFiscalesFromInstance(datosFiscalesInstance, instance){
    if(!instance) return
    instance.datosFiscales = null
    instance.save()

    if(datosFiscalesInstance.address){
      def address = datosFiscalesInstance.address
      datosFiscalesInstance.address = null
      datosFiscalesInstance.save()

      address.delete()
    }

    datosFiscalesInstance.delete()
  }

}
