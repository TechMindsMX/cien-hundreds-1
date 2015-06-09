package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Product)
class ProductSpec extends Specification {

  @Unroll
  void "When we have a product with: name #name, description: #description, benefits: #benefits, target: #target, competence #competence, videoLink: #videoLink, clients: #clients customerModel: #customerModel"() {
  given: "A product"
    def product = new Product()
  and: "A company"
    def company = new Company()
    product.company = company
  when: "We assign values"
    product.name = name
    product.description = description
    product.benefits = benefits
    product.target = target
    product.competence = competence
    product.videoLink = videoLink
    product.clients = clients
    product.customerModel = customerModel
    product.web = true
    product.telephone = true
    product.campaign = true
    product.event = true
    product.other = true
  then: "We validate result"
    result == product.validate()
  where: "We have next values"
  name      | description | benefits   | target   | competence   | videoLink                      | clients   | customerModel   || result
  'product' | 'desc'      | 'benefits' | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || true
  'p'       | 'desc'      | 'benefits' | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || true
  'product' | 'd'         | 'benefits' | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || true
  'product' | 'desc'      | 'b'        | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || true
  'product' | 'desc'      | 'benefits' | 't'      | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || true
  'product' | 'desc'      | 'benefits' | 'target' | 'c'          | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || true
  'product' | 'desc'      | 'benefits' | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'c'       | 'customerModel' || true
  'product' | 'desc'      | 'benefits' | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'c'             || true
  }


  @Unroll
  void "When we have a product with: name #name, description: #description, benefits: #benefits, target: #target, competence #competence, videoLink: #videoLink, clients: #clients customerModel: #customerModel"() {
  given: "A product"
    def product = new Product()
  and: "A company"
    def company = new Company()
    product.company = company
  when: "We assign values"
    product.name = name
    product.description = description
    product.benefits = benefits
    product.target = target
    product.competence = competence
    product.videoLink = videoLink
    product.clients = clients
    product.customerModel = customerModel
    product.web = true
    product.telephone = true
    product.campaign = true
    product.event = true
    product.other = true
  then: "We validate result"
    result == product.validate()
  where: "We have next values"
  name      | description | benefits   | target   | competence   | videoLink                      | clients   | customerModel   || result
  ''        | 'desc'      | 'benefits' | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || false
  null      | 'desc'      | 'benefits' | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || false
  'product' | ''          | 'benefits' | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || false
  'product' | null        | 'benefits' | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || false
  'product' | 'desc'      | ''         | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || false
  'product' | 'desc'      | null       | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || false
  'product' | 'desc'      | 'benefits' | ''       | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || false
  'product' | 'desc'      | 'benefits' | null     | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || false
  'product' | 'desc'      | 'benefits' | 'target' | ''           | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || false
  'product' | 'desc'      | 'benefits' | 'target' | null         | 'https://youtu.be/LKckM5gq7VU' | 'clients' | 'customerModel' || false
  'product' | 'desc'      | 'benefits' | 'target' | 'competence' | 'h'                            | 'clients' | 'customerModel' || false
  'product' | 'desc'      | 'benefits' | 'target' | 'competence' | null                           | 'clients' | 'customerModel' || false
  'product' | 'desc'      | 'benefits' | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | ''        | 'customerModel' || false
  'product' | 'desc'      | 'benefits' | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | null      | 'customerModel' || false
  'product' | 'desc'      | 'benefits' | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | ''              || false
  'product' | 'desc'      | 'benefits' | 'target' | 'competence' | 'https://youtu.be/LKckM5gq7VU' | 'clients' | null            || false
  }

}
