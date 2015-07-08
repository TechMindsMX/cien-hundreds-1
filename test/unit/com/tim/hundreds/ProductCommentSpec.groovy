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
  }
}
