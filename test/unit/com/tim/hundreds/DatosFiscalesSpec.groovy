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
  def """When we have datos fiscales with razonSocial: #razonSocial, rfc: #rfc, personaJuridica #personaJuridica we expect result: #result"""() {
  given: "A datos ficales"
    def datosFiscales = new DatosFiscales()
  when: "We assign values"
    datosFiscales.razonSocial = razonSocial
    datosFiscales.rfc = rfc
    datosFiscales.personaJuridica = personaJuridica
    datosFiscales.musician = musician
    datosFiscales.company = company

    datosFiscales.validate()
    print datosFiscales.dump()
  then: "We validate result"
    result == datosFiscales.validate()
  where: "We have next values"
  razonSocial           | rfc             | personaJuridica             | musician       | company       || result
  'Above & Beyond Inc.' | 'ABO8012028D3'  | PersonaJuridicaType.MORAL   | new Musician() | null          || true
  'Above & Beyond Inc.' | 'ABO8012028D3'  | PersonaJuridicaType.MORAL   | null           | new Company() || true
  'Above & Beyond Inc.' | 'AABO8012028D3' | PersonaJuridicaType.MORAL   | new Musician() | null          || false
  'A'                   | 'AABO8012028D3' | PersonaJuridicaType.MORAL   | new Musician() | null          || false
  ''                    | 'ABO8012028D3'  | PersonaJuridicaType.MORAL   | new Musician() | null          || false
  null                  | 'ABO8012028D3'  | PersonaJuridicaType.MORAL   | new Musician() | null          || false
  'Above & Beyond Inc.' | ''              | PersonaJuridicaType.MORAL   | new Musician() | null          || false
  'Above & Beyond Inc.' | null            | PersonaJuridicaType.MORAL   | new Musician() | null          || false
  'Above & Beyond Inc.' | 'ABOD8012028D3' | PersonaJuridicaType.FISICA  | new Musician() | null          || true
  'Above & Beyond Inc.' | 'ABOD8012028D3' | PersonaJuridicaType.FISICA  | null           | new Company() || true
  'Above & Beyond Inc.' | 'AAB8012028D3'  | PersonaJuridicaType.FISICA  | new Musician() | null          || false
  'A'                   | 'AAB8012028D3'  | PersonaJuridicaType.FISICA  | new Musician() | null          || false
  ''                    | 'ABOD8012028D3' | PersonaJuridicaType.FISICA  | new Musician() | null          || false
  null                  | 'ABOD8012028D3' | PersonaJuridicaType.FISICA  | new Musician() | null          || false
  'Above & Beyond Inc.' | ''              | PersonaJuridicaType.FISICA  | new Musician() | null          || false
  'Above & Beyond Inc.' | null            | PersonaJuridicaType.FISICA  | new Musician() | null          || false
  }
}