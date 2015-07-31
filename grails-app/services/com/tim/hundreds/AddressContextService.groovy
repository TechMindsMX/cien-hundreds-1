package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class AddressContextService {
  def addressService

  def saveInstance(addressInstance) {
    if(addressInstance.musician){
      def musician = addressInstance.musician
      musician.address = addressInstance
      musician.save flush:true
    }
    if(addressInstance.datosFiscales){
      def datosFiscales = addressInstance.datosFiscales
      datosFiscales.address = addressInstance
      company.save flush:true
    }
    if(addressInstance.contact){
      def contact = addressInstance.contact
      contact.address = addressInstance
      contact.save flush:true
    }
    if(addressInstance.company){
      def company = addressInstance.company
      company.address = addressInstance
      company.save flush:true
    }
  }

  def deleteInstance(addressInstance) {
    def musician = Musician.findByAddress(addressInstance)
    addressService.deleteAddressFromInstance(addressInstance, musician)

    def contact = Contact.findByAddress(addressInstance)
    addressService.deleteAddressFromInstance(addressInstance, contact)

    def company = Company.findByAddress(addressInstance)
    addressService.deleteAddressFromInstance(addressInstance, company)
  }

}
