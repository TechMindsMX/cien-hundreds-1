package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Suggestion)
class SuggestionSpec extends Specification {

  @Unroll
  void """When we have a suggestion with name: #name, contactName: #contactName, email: #email, phone: #phone we expect result is: #result"""() {
  given: "A suggestion"
    def suggestion = new Suggestion()
  and: "A musician"
    def musician = new Musician(name:'name', description:'desc')
    suggestion.musician = musician
  when: "We asssig values"
    suggestion.name = name
    suggestion.contactName = contactName
    suggestion.email = email
    suggestion.phone = phone
  then: "We validate result"
    result == suggestion.validate()
  where: "We have next values"
  name    | contactName   | email              | phone         || result
  'name'  | 'contactName' | 'josdem@email.com' | '1234567890'  || true
  'n'     | 'contactName' | 'josdem@email.com' | '1234567890'  || true
  'name'  | 'c'           | 'josdem@email.com' | '1234567890'  || true
  'name'  | 'contactName' | 'josdem@email.com' | '1234567890'  || true
  'name'  | 'contactName' | 'josdem@email.com' | '1234567890'  || true
  ''      | 'contactName' | 'josdem@email.com' | '1234567890'  || false
  null    | 'contactName' | 'josdem@email.com' | '1234567890'  || false
  'name'  | ''            | 'josdem@email.com' | '1234567890'  || false
  'name'  | null          | 'josdem@email.com' | '1234567890'  || false
  'name'  | 'contactName' | 'josdem@email'     | '1234567890'  || false
  'name'  | 'contactName' | 'josdem@emailcom'  | '1234567890'  || false
  'name'  | 'contactName' | 'josdememail.com'  | '1234567890'  || false
  'name'  | 'contactName' | 'josdem'           | '1234567890'  || false
  'name'  | 'contactName' | 'josdem@email.com' | '12345678901' || false
  'name'  | 'contactName' | 'josdem@email.com' | '123456789'   || false
  'name'  | 'contactName' | 'josdem@email.com' | 'ABCDE12345'  || false
  'name'  | 'contactName' | 'josdem@email.com' | 'ABCDEFGHIJ'  || false
  'name'  | 'contactName' | 'josdem@email.com' | 'abcde12345'  || false
  }

}
