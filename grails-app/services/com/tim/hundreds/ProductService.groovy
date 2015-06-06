package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class ProductService {

  def save(productInstance) {
    log.info "Products by company: ${Product.findByCompany(productInstance.company)?.count()}"

    def company = productInstance.company
    company.addToProducts(productInstance)
    company.save(failOnError: true)

    productInstance
  }

}
