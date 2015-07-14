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
  then: "We validate address values"
    result == address.validate()
  where: "We have next cases"
  street   | zipcode   | neighborhood   | county   | town   | state   | country   || result
  "street" | "12345"   | "neighborhood" | 'county' | "town" | "state" | "country" || true
  "street" | "12345"   | "neighborhood" | ''       | "town" | "state" | "country" || true
  "street" | "12345"   | "neighborhood" | null     | "town" | "state" | "country" || true
  ""       | "12345"   | "neighborhood" | 'county' | "town" | "state" | "country" || false
  null     | "12345"   | "neighborhood" | 'county' | "town" | "state" | "country" || false
  "street" | "1234"    | "neighborhood" | 'county' | "town" | "state" | "country" || false
  "street" | "123456"  | "neighborhood" | 'county' | "town" | "state" | "country" || false
  "street" | "123"     | "neighborhood" | 'county' | "town" | "state" | "country" || false
  "street" | "12"      | "neighborhood" | 'county' | "town" | "state" | "country" || false
  "street" | "1"       | "neighborhood" | 'county' | "town" | "state" | "country" || false
  "street" | ""        | "neighborhood" | 'county' | "town" | "state" | "country" || false
  "street" | null      | "neighborhood" | 'county' | "town" | "state" | "country" || false
  "street" | "12345"   | ""             | 'county' | "town" | "state" | "country" || false
  "street" | "12345"   | null           | 'county' | "town" | "state" | "country" || false
  "street" | "12345"   | "neighborhood" | 'county' | ""     | "state" | "country" || false
  "street" | "12345"   | "neighborhood" | 'county' | null   | "state" | "country" || false
  "street" | "12345"   | "neighborhood" | 'county' | "town" | ""      | "country" || false
  "street" | "12345"   | "neighborhood" | 'county' | "town" | null    | "country" || false
  "street" | "12345"   | "neighborhood" | 'county' | "town" | "state" | ""        || false
  "street" | "12345"   | "neighborhood" | 'county' | "town" | "state" | null      || false
  }
}
