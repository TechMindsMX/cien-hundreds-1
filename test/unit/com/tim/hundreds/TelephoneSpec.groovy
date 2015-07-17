package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Telephone)
class TelephoneSpec extends Specification {

  @Unroll
  void """When we have a telephone with phone: #phone, type: #type we expect result: #result"""() {
  given: "A telephone"
    def telephone = new Telephone()
  when: "We assign values"
    telephone.phone = phone
    telephone.type = type
  then: "We validate result"
    result == telephone.validate()
  where: "We have next values"
  phone         | type                          || result
  '1234567890'  | TelephoneType.PERSONAL_MOBILE || true
  '1234567890'  | TelephoneType.WORK_MOBILE     || true
  '1234567890'  | TelephoneType.PERSONAL        || true
  '1234567890'  | TelephoneType.WORK            || true
  '12345678901' | TelephoneType.WORK            || false
  '123456789'   | TelephoneType.WORK            || false
  'ABCDEFGHIJ'  | TelephoneType.WORK            || false
  'ABCDE12345'  | TelephoneType.WORK            || false
  'abcde12345'  | TelephoneType.WORK            || false
  ''            | TelephoneType.WORK            || false
  null          | TelephoneType.WORK            || false
  }

}
