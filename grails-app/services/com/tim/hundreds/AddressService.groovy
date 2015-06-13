package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class AddressService {

  def saveAddressToInstance(addressInstance, instance){
    addressInstance.save flush: true
    instance.address = addressInstance
    instance.save()

    instance
  }

  def deleteAddressFromInstance(addressInstance, instance){
    if(!instance) return
    instance.address = null
    instance.save()

    addressInstance.delete()
  }

}
