package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(ProductComment)
class ProductCommentSpec extends Specification {

  @Unroll
  void """When we have a product comment with general: #general, description: #description, benefits: #benefits, target: #target, competence: #competence, discountModel: #discountModel, distributionModel: #distributionModel, customerModel: #customerModel, notes: #notes when we validate we expect result: #result"""() {
  given:"A product comment"
    def productComment = new ProductComment()
  and: "A Product"
    def product = new Product()
    productComment.product = product
  when:"We assign values"
    productComment.general = general
    productComment.description = description
    productComment.benefits = benefits
    productComment.target = target
    productComment.competence = competence
    productComment.discountModel = discountModel
    productComment.customerModel = customerModel
    productComment.notes = notes
  then: "We validate product"
    result == productComment.validate()
  where: "We have next values"
  general   | description   | benefits   | target   | competence   | discountModel   | distributionModel   | customerModel   | notes   || result
  'general' | 'description' | 'benefits' | 'target' | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || true
  'g'       | 'description' | 'benefits' | 'target' | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || true
  'general' | 'd'           | 'benefits' | 'target' | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || true
  'general' | 'description' | 'b'        | 'target' | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || true
  'general' | 'description' | 'benefits' | 't'      | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || true
  'general' | 'description' | 'benefits' | 'target' | 'c'          | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || true
  'general' | 'description' | 'benefits' | 'target' | 'competence' | 'd'             | 'distributionModel' | 'customerModel' | 'notes' || true
  'general' | 'description' | 'benefits' | 'target' | 'competence' | 'discountModel' | 'd'                 | 'customerModel' | 'notes' || true
  'general' | 'description' | 'benefits' | 'target' | 'competence' | 'discountModel' | 'distributionModel' | 'c'             | 'notes' || true
  'general' | 'description' | 'benefits' | 'target' | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | 'n'     || true
  null      | 'description' | 'benefits' | 'target' | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || true
  'general' | null          | 'benefits' | 'target' | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || true
  'general' | 'description' | null       | 'target' | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || true
  'general' | 'description' | 'benefits' | null     | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || true
  'general' | 'description' | 'benefits' | 'target' | null         | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || true
  'general' | 'description' | 'benefits' | 'target' | 'competence' | null            | 'distributionModel' | 'customerModel' | 'notes' || true
  'general' | 'description' | 'benefits' | 'target' | 'competence' | 'discountModel' | null                | 'customerModel' | 'notes' || true
  'general' | 'description' | 'benefits' | 'target' | 'competence' | 'discountModel' | 'distributionModel' | null            | 'notes' || true
  'general' | 'description' | 'benefits' | 'target' | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | null    || true
  ''        | 'description' | 'benefits' | 'target' | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || false
  'general' | ''            | 'benefits' | 'target' | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || false
  'general' | 'description' | ''         | 'target' | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || false
  'general' | 'description' | 'benefits' | ''       | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || false
  'general' | 'description' | 'benefits' | 'target' | ''           | 'discountModel' | 'distributionModel' | 'customerModel' | 'notes' || false
  'general' | 'description' | 'benefits' | 'target' | 'competence' | ''              | 'distributionModel' | 'customerModel' | 'notes' || false
  'general' | 'description' | 'benefits' | 'target' | 'competence' | 'discountModel' | ''                  | 'customerModel' | 'notes' || false
  'general' | 'description' | 'benefits' | 'target' | 'competence' | 'discountModel' | 'distributionModel' | ''              | 'notes' || false
  'general' | 'description' | 'benefits' | 'target' | 'competence' | 'discountModel' | 'distributionModel' | 'customerModel' | ''      || false
  }
}
