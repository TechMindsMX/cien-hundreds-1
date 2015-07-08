package com.tim.hundreds

class TokenGenerator {
  static def generateToken() {
    UUID.randomUUID().toString().replaceAll('-', '');
  }
}
