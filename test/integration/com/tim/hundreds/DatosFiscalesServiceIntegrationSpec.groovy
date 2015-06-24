package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */

class DatosFiscalesServiceIntegrationSpec extends Specification {
  def datosFiscalesService

  void "Should save datosFiscalesInstance to musician"() {
    given: "An instance"
      def instance = new Musician(name:'name',history:'history')
      instance.genre = GenreType.TRANCE
      instance.hasManager = true
      instance.dateCreated = new Date()
      instance.lastUpdated = new Date()
      instance.formed = new Date()
    and: "Above & Beyond rfc"
      def rfc = 'AJU8012028D3'
    and: "We save instance"
      instance.save(flush: true)
    and: "We create an datosFiscalesInstance"
      def datosFiscalesInstance = new DatosFiscales(razonSocial:'Above & Beyond Inc.',rfc:rfc)
    when: "We save to instance"
      def result = datosFiscalesService.saveDatosFiscalesToInstance(datosFiscalesInstance, instance)
    then: "We expect same social"
      result.datosFiscales
      result.datosFiscales.rfc == rfc
  }

  void "Should save datosFiscalesInstance to company"() {
    given: "An instance"
      def instance = new Company(name:'Anjunabeats',description:'Music Production')
      instance.type = ActivityType.PRODUCTOS
    and: "Above & Beyond rfc"
      def rfc = 'AJU8012028D3'
    and: "We save instance"
      instance.save(flush: true)
    and: "We create an datosFiscalesInstance"
      def datosFiscalesInstance = new DatosFiscales(razonSocial:'Above & Beyond Inc.',rfc:rfc)
    when: "We save to instance"
      def result = datosFiscalesService.saveDatosFiscalesToInstance(datosFiscalesInstance, instance)
    then: "We expect same social"
      result.datosFiscales
      result.datosFiscales.rfc == rfc
  }
}
