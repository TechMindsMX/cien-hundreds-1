package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Address)
class AddressSpec extends Specification {

  @Unroll
  void """When we have an address with: street: #street, zipcode: #zipcode, neighborhood: #neighborhood, town: #town, state: #state, country: #country, and we validate we expect result #result"""() {
  given: "An address"
    def address = new Address()
  when: "We assign values to the address"
    address.street = street
    address.zipcode = zipcode
    address.neighborhood = neighborhood
    address.county = county
    address.town = town
    address.state = state
    address.country = country

    address.musician = musician
    address.company = company
    address.contact = contact
    address.datosFiscales = datosFiscales
  then: "We validate address values"
    result == address.validate()
  where: "We have next cases"
  street   | zipcode   | neighborhood   | county   | town   | state   | country   | contact       | company       | datosFiscales       | musician       || result
  "street" | "12345"   | "neighborhood" | 'county' | "town" | "state" | "country" | new Contact() | null          | null                | null           || true
  "street" | "12345"   | "neighborhood" | 'county' | "town" | "state" | "country" | null          | new Company() | null                | null           || true
  "street" | "12345"   | "neighborhood" | 'county' | "town" | "state" | "country" | null          | null          | new DatosFiscales() | null           || true
  "street" | "12345"   | "neighborhood" | ''       | "town" | "state" | "country" | null          | null          | null                | new Musician() || true
  "street" | "12345"   | "neighborhood" | ''       | "town" | "state" | "country" | new Contact() | null          | null                | null           || true
  "street" | "12345"   | "neighborhood" | null     | "town" | "state" | "country" | new Contact() | null          | null                | null           || true
  ""       | "12345"   | "neighborhood" | 'county' | "town" | "state" | "country" | new Contact() | null          | null                | null           || false
  null     | "12345"   | "neighborhood" | 'county' | "town" | "state" | "country" | new Contact() | null          | null                | null           || false
  "street" | "1234"    | "neighborhood" | 'county' | "town" | "state" | "country" | new Contact() | null          | null                | null           || false
  "street" | "123456"  | "neighborhood" | 'county' | "town" | "state" | "country" | new Contact() | null          | null                | null           || false
  "street" | "123"     | "neighborhood" | 'county' | "town" | "state" | "country" | new Contact() | null          | null                | null           || false
  "street" | "12"      | "neighborhood" | 'county' | "town" | "state" | "country" | new Contact() | null          | null                | null           || false
  "street" | "1"       | "neighborhood" | 'county' | "town" | "state" | "country" | new Contact() | null          | null                | null           || false
  "street" | ""        | "neighborhood" | 'county' | "town" | "state" | "country" | new Contact() | null          | null                | null           || false
  "street" | null      | "neighborhood" | 'county' | "town" | "state" | "country" | new Contact() | null          | null                | null           || false
  "street" | "12345"   | ""             | 'county' | "town" | "state" | "country" | new Contact() | null          | null                | null           || false
  "street" | "12345"   | null           | 'county' | "town" | "state" | "country" | new Contact() | null          | null                | null           || false
  "street" | "12345"   | "neighborhood" | 'county' | ""     | "state" | "country" | new Contact() | null          | null                | null           || false
  "street" | "12345"   | "neighborhood" | 'county' | null   | "state" | "country" | new Contact() | null          | null                | null           || false
  "street" | "12345"   | "neighborhood" | 'county' | "town" | ""      | "country" | new Contact() | null          | null                | null           || false
  "street" | "12345"   | "neighborhood" | 'county' | "town" | null    | "country" | new Contact() | null          | null                | null           || false
  "street" | "12345"   | "neighborhood" | 'county' | "town" | "state" | ""        | new Contact() | null          | null                | null           || false
  "street" | "12345"   | "neighborhood" | 'county' | "town" | "state" | null      | new Contact() | null          | null                | null           || false
  }
}
