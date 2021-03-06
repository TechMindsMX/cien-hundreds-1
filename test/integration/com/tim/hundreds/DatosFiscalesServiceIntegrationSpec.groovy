package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

class DatosFiscalesServiceIntegrationSpec extends Specification {
  def datosFiscalesService

  void "Should save datosFiscalesInstance to musician"() {
    given: "An genre"
      def genre = new Genre(name: 'Trance').save()
    and: "An instance"
      def instance = new Musician(name:'name',history:'history')
      instance.genre = genre
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
      instance.type = new BusinessActivity(name:'Products')
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
