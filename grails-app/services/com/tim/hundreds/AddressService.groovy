package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class AddressService {

  def saveMusician(addressInstance, musician){
    addressInstance.save flush:true
    musician.address = addressInstance
    musician.save()
  }

  def saveDatosFiscales(addressInstance, datosFiscales){
    addressInstance.save flush:true
    datosFiscales.address = addressInstance
    datosFiscales.save()
  }

  def saveContact(addressInstance, contact){
    addressInstance.save flush:true
    contact.address = addressInstance
    contact.save()
  }

  def saveAddressToInstance(addressInstance, instance){
    addressInstance.save flush:true
    instance.address = addressInstance
    instance.save()
  }

}
