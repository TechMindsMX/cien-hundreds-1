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
    Address address = new Address()
  when: "We assign values to the address"
    address.street = street
    address.zipcode = zipcode
    address.neighborhood = neighborhood
    address.town = town
    address.state = state
    address.country = country
  then: "We validate address values"
    result == address.validate()
  where: "We have next cases"
  street   | zipcode   | neighborhood   | town   | state   | country   || result
  "street" | "12345"   | "neighborhood" | "town" | "state" | "country" || true
  ""       | "12345"   | "neighborhood" | "town" | "state" | "country" || false
  null     | "12345"   | "neighborhood" | "town" | "state" | "country" || false
  "street" | "1234"    | "neighborhood" | "town" | "state" | "country" || false
  "street" | "123456"  | "neighborhood" | "town" | "state" | "country" || false
  "street" | "123"     | "neighborhood" | "town" | "state" | "country" || false
  "street" | "12"      | "neighborhood" | "town" | "state" | "country" || false
  "street" | "1"       | "neighborhood" | "town" | "state" | "country" || false
  "street" | ""        | "neighborhood" | "town" | "state" | "country" || false
  "street" | null      | "neighborhood" | "town" | "state" | "country" || false
  "street" | "12345"   | ""             | "town" | "state" | "country" || false
  "street" | "12345"   | null           | "town" | "state" | "country" || false
  "street" | "12345"   | "neighborhood" | ""     | "state" | "country" || false
  "street" | "12345"   | "neighborhood" | null   | "state" | "country" || false
  "street" | "12345"   | "neighborhood" | "town" | ""      | "country" || false
  "street" | "12345"   | "neighborhood" | "town" | null    | "country" || false
  "street" | "12345"   | "neighborhood" | "town" | "state" | ""        || false
  "street" | "12345"   | "neighborhood" | "town" | "state" | null      || false
  }
}
