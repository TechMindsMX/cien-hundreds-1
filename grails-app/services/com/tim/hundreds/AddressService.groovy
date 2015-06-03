package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class AddressService {

  def save(addressInstance, datosFiscalesId){
    addressInstance.save flush:true
    def datosFiscales = DatosFiscales.findById(datosFiscalesId)
    datosFiscales.address = addressInstance
    datosFiscales.save()
  }
}
