package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class TokenService {
  static def generateToken() {
    UUID.randomUUID().toString().replace("-", "");
  }
}
