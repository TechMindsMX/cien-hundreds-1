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
  void """When we have datos fiscales with razonSocial: #razonSocial, rfc: #rfc, personaJuridica #personaJuridica we expect result: #result"""() {
  given: "A datos ficales"
    def datosFiscales = new DatosFiscales()
  when: "We assign values"
    datosFiscales.razonSocial = razonSocial
    datosFiscales.rfc = rfc
    datosFiscales.personaJuridica = personaJuridica
    datosFiscales.validate()
    print datosFiscales.dump()
  then: "We validate result"
    result == datosFiscales.validate()
  where: "We have next values"
  razonSocial           | rfc             | personaJuridica             || result
  'Above & Beyond Inc.' | 'ABO8012028D3'  | PersonaJuridicaType.MORAL   || true
  'A'                   | 'ABO8012028D3'  | PersonaJuridicaType.MORAL   || true
  'Above & Beyond Inc.' | 'AABO8012028D3' | PersonaJuridicaType.MORAL   || false
  'A'                   | 'AABO8012028D3' | PersonaJuridicaType.MORAL   || false
  ''                    | 'ABO8012028D3'  | PersonaJuridicaType.MORAL   || false
  null                  | 'ABO8012028D3'  | PersonaJuridicaType.MORAL   || false
  'Above & Beyond Inc.' | ''              | PersonaJuridicaType.MORAL   || false
  'Above & Beyond Inc.' | null            | PersonaJuridicaType.MORAL   || false
  'Above & Beyond Inc.' | 'ABOD8012028D3' | PersonaJuridicaType.FISICA  || true
  'A'                   | 'ABOD8012028D3' | PersonaJuridicaType.FISICA  || true
  'Above & Beyond Inc.' | 'AAB8012028D3'  | PersonaJuridicaType.FISICA  || false
  'A'                   | 'AAB8012028D3'  | PersonaJuridicaType.FISICA  || false
  ''                    | 'ABOD8012028D3' | PersonaJuridicaType.FISICA  || false
  null                  | 'ABOD8012028D3' | PersonaJuridicaType.FISICA  || false
  'Above & Beyond Inc.' | ''              | PersonaJuridicaType.FISICA  || false
  'Above & Beyond Inc.' | null            | PersonaJuridicaType.FISICA  || false
  }
}
