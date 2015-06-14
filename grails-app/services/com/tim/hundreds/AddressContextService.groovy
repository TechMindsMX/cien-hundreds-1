package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class AddressContextService {
  def addressService

  def saveInstance(addressInstance, params) {
    if(params.musicianUuid){
      def musician = Musician.findByUuid(params.musicianUuid)
      addressService.saveAddressToInstance(addressInstance, musician)
    }
    if(params.datosFiscalesUuid){
      def datosFiscales = DatosFiscales.findByUuid(params.datosFiscalesUuid)
      addressService.saveAddressToInstance(addressInstance, datosFiscales)
    }
    if(params.contactUuid){
      def contact = Contact.findByUuid(params.contactUuid)
      addressService.saveAddressToInstance(addressInstance, contact)
    }
    if(params.companyUuid){
      def company = Company.findByUuid(params.companyUuid)
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
