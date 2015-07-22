package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class AddressContextService {
  def addressService

  def saveInstance(addressInstance, params) {
    if(params.musician.id){
      def musician = Musician.findById(params.musician.id)
      addressService.saveAddressToInstance(addressInstance, musician)
    }
    if(params.datosFiscales.id){
      def datosFiscales = DatosFiscales.findById(params.datosFiscales.id)
      addressService.saveAddressToInstance(addressInstance, datosFiscales)
    }
    if(params.contact.id){
      def contact = Contact.findById(params.contact.id)
      addressService.saveAddressToInstance(addressInstance, contact)
    }
    if(params.company.id){
      def company = Company.findById(params.company.id)
      addressService.saveAddressToInstance(addressInstance, company)
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
