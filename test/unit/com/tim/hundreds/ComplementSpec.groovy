package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Complement)
class ComplementSpec extends Specification {

  @Unroll
  void """When we have a complement with name: #name and price: #price we expect result: #result"""() {
  given: "A complement"
    def complement = new Complement()
  and: "A product"
    def product = new Product()
    complement.product = product
  when: "We assign values"
    complement.name = name
    complement.price = price
  then: "We validate result"
    result == complement.validate()
  where: "We have next cases"
  name   | price || result
  'name' | 100   || true
  'n'    | 100   || true
  'name' | 0.01  || true
  ''     | 100   || false
  null   | 100   || false
  'name' | 0     || false
  'name' | 0.00  || false
  'name' | -0.01 || false
  'name' | -1    || false
  'name' | null  || false
  }

}
