package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class AddressService {

  def deleteAddressFromInstance(addressInstance, instance){
    if(!instance) return
    instance.address = null
    instance.save()

    addressInstance.delete()
  }

}
