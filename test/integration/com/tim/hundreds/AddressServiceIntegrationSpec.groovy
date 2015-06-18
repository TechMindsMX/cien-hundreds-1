package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Shared

class AddressServiceIntegrationSpec extends Specification {
  def addressService
  @Shared musician
  @Shared contact
  @Shared company

  def setupSpec(){
    musician = new Musician(name:'name',history:'history')
    musician.genre = Genre.TRANCE
    musician.hasManager = true
    musician.dateCreated = new Date()
    musician.lastUpdated = new Date()
    musician.formed = new Date()

    musician.save flush: true

    contact = new Contact(firstName:'firstName',middleName:'middleName',lastName:'lastName')
    contact.type = GenderType.MALE
    contact.role = RoleType.MANAGER
    contact.birthDate = new Date()
    contact.entryDate = new Date()

    contact.save flush: true

    company = new Company(name:'Anjunabeats',description:'Music Production')
    company.type = ActivityType.PRODUCTOS

    company.save flush: true
  }

  void "Should save addressInstance to musician"() {
    given: "Above & Beyond street"
      def street = 'street'
    and: "We create an addressInstance"
      def addressInstance = new Address(street:'street',zipcode:'zipcode',neighborhood:'neighborhood',town:'town',state:'state',county:'country')
    when: "We save to instance"
      def result = addressService.saveAddressToInstance(addressInstance, musician)
    then: "We expect same address"
      result.address
      result.address.street == street
  }

  void "Should save addressInstance to contact"() {
    given: "Above & Beyond twitter"
      def street = 'street'
    and: "We create an addressInstance"
      def addressInstance = new Address(street:'street',zipcode:'zipcode',neighborhood:'neighborhood',town:'town',state:'state',county:'country')
    when: "We save to instance"
      def result = addressService.saveAddressToInstance(addressInstance, contact)
    then: "We expect same address"
      result.address
      result.address.street == street
  }

  void "Should save addressInstance to company"() {
    given: "Street"
      def street = 'street'
    and: "We create an addressInstance"
      def addressInstance = new Address(street:'street',zipcode:'zipcode',neighborhood:'neighborhood',town:'town',state:'state',county:'country')
    when: "We save to instance"
      def result = addressService.saveAddressToInstance(addressInstance, company)
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

  void "Should delete address from musician"() {
    given: "Above & Beyond street"
      def street = 'street'
    and: "We create an addressInstance"
      def addressInstance = new Address(street:'street',zipcode:'zipcode',neighborhood:'neighborhood',town:'town',state:'state',county:'country')
    when: "We save to instance"
      addressService.saveAddressToInstance(addressInstance, musician)
      assert musician.address
      def result = addressService.deleteAddressFromInstance(addressInstance, musician)
    then: "We expect no address"
      !result
  }

  void "Should delete address to contact"() {
    given: "Above & Beyond twitter"
      def street = 'street'
    and: "We create an addressInstance"
      def addressInstance = new Address(street:'street',zipcode:'zipcode',neighborhood:'neighborhood',town:'town',state:'state',county:'country')
    when: "We save to instance"
      addressService.saveAddressToInstance(addressInstance, contact)
      assert contact.address
      def result = addressService.deleteAddressFromInstance(addressInstance, contact)
    then: "We expect no address"
      !result
  }

  def cleanupSpec(){
    musician.delete flush:true
    contact.delete flush:true
    company.delete flush:true
  }

}
