package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */

class AddressServiceIntegrationSpec extends Specification {
  def addressService

  void "Should save addressInstance to musician"() {
    given: "An instance"
      def instance = new Musician(name:'name',history:'history')
      instance.genre = Genre.TRANCE
      instance.hasManager = true
      instance.dateCreated = new Date()
      instance.lastUpdated = new Date()
      instance.formed = new Date()
    and: "Above & Beyond twitter"
      def street = 'street'
    and: "We save instance"
      instance.save(flush: true)
    and: "We create an addressInstance"
      def addressInstance = new Address(street:'street',zipcode:'zipcode',neighborhood:'neighborhood',town:'town',state:'state',county:'country')
    when: "We save to instance"
      def result = addressService.saveAddressToInstance(addressInstance, instance)
    then: "We expect same address"
      result.address
      result.address.street == street
  }

  void "Should save addressInstance to contact"() {
    given: "An instance"
      def instance = new Contact(firstName:'firstName',middleName:'middleName',lastName:'lastName')
      instance.type = GenderType.MALE
      instance.role = RoleType.MANAGER
      instance.birthDate = new Date()
      instance.entryDate = new Date()
    and: "Above & Beyond twitter"
      def street = 'street'
    and: "We save instance"
      instance.save(flush: true)
    and: "We create an addressInstance"
      def addressInstance = new Address(street:'street',zipcode:'zipcode',neighborhood:'neighborhood',town:'town',state:'state',county:'country')
    when: "We save to instance"
      def result = addressService.saveAddressToInstance(addressInstance, instance)
    then: "We expect same address"
      result.address
      result.address.street == street
  }

  void "Should save addressInstance to company"() {
    given: "An instance"
      def instance = new Company(name:'Anjunabeats',description:'Music Production')
      instance.type = ActivityType.PRODUCTOS
    and: "Street"
      def street = 'street'
    and: "We save instance"
      instance.save(flush: true)
    and: "We create an addressInstance"
      def addressInstance = new Address(street:'street',zipcode:'zipcode',neighborhood:'neighborhood',town:'town',state:'state',county:'country')
    when: "We save to instance"
      def result = addressService.saveAddressToInstance(addressInstance, instance)
    then: "We expect same address"
      result.address
      result.address.street == street
  }

  void "Should save addressInstance to datosFiscales"() {
    given: "An instance"
      def instance = new DatosFiscales(razonSocial:'Above & Beyond Inc.', rfc:'ANJ8012028D3')
    and: "Street"
      def street = 'street'
    and: "We save instance"
      instance.save(flush: true)
    and: "We create an addressInstance"
      def addressInstance = new Address(street:'street',zipcode:'zipcode',neighborhood:'neighborhood',town:'town',state:'state',county:'country')
    when: "We save to instance"
      def result = addressService.saveAddressToInstance(addressInstance, instance)
    then: "We expect same address"
      result.address
      result.address.street == street
  }
}
