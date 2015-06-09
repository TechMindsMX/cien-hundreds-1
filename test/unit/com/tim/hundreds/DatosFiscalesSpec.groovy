package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DatosFiscales)
class DatosFiscalesSpec extends Specification {

  @Unroll
  void """When we have datos fiscales with razonSocial: #razonSocial, rfc: #rfc, personaMoral #personaMoral, personaFisica: #personaFisica we expect result: #result"""() {
  given: "A datos ficales"
    def datosFiscales = new DatosFiscales()
  when: "We assign values"
    datosFiscales.razonSocial = razonSocial
    datosFiscales.rfc = rfc
    datosFiscales.personaMoral = personaMoral
    datosFiscales.personaFisica = personaFisica
  then: "We validate result"
    result == datosFiscales.validate()
  where: "We have next values"
  razonSocial           | rfc            | personaMoral | personaFisica || result
  'Above & Beyond Inc.' | 'ABO8012028D3' | true         | true          || true
  'A'                   | 'ABO8012028D3' | true         | true          || true
  'Above & Beyond Inc.' | 'ABO8012028D3' | false        | true          || true
  'Above & Beyond Inc.' | 'ABO8012028D3' | true         | false         || true
  'Above & Beyond Inc.' | 'ABO8012028D3' | true         | true          || true
  'Above & Beyond Inc.' | 'ABO8012028D3' | true         | true          || true
  ''                    | 'ABO8012028D3' | true         | true          || false
  null                  | 'ABO8012028D3' | true         | true          || false
  'Above & Beyond Inc.' | ''             | true         | true          || false
  'Above & Beyond Inc.' | null           | true         | true          || false
  }
}
