package com.tim.hundreds

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 */
@TestFor(User)
class UserSpec extends Specification {
  @Unroll
  void """When we have a user with email:  #email, emailCheck: #emailCheck, firstName: #firstName, middleName: #middleName, lastName: #lastName, username: #username, password: #password, passwordCheck: #passwordCheck, phone: #phone, role: #role, terms: #terms we expect the result is: #result"""() {
    given: "An user"
      UserCommand user = new UserCommand()
    when: "We assing values to command"
      user.email = email
      user.emailCheck = emailCheck
      user.firstName = firstName
      user.middleName = middleName
      user.lastName = lastName
      user.username = username
      user.password = password
      user.passwordCheck = passwordCheck
      user.phone = phone
      user.role = role
      user.terms = terms
      user.status = true
    then:"We validate command"
      result == user.validate()
    where:"We have the next cases"
    email              | emailCheck         |firstName |middleName    |lastName   |username  |password      | passwordCheck| phone        | role        | terms || result
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || true
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | null         | "ROLE_USER" | 'on'  || true
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | null         | "ROLE_USER" | 'on'  || true
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "M"       | "josdem" | "aA12345678" | "aA12345678" | null         | "ROLE_USER" | 'on'  || true
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "M"       | "josdem" | "aA12345678" | "aA12345678" | null         | "ROLE_USER" | null  || false
    null               | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    ""                 | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem"           | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "jos@gmail"        | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | null     | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | ""       | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | null         | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | ""           | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | null      | "josdem" | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | ""        | "josdem" | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | null     | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | ""       | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | null         | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | ""           | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | ""           | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "1"          | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "55123456789"| "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "551234567"  | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "ABCDEFGHIJ" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "12345678"   | "12345678"   | "ABCDEFGHIJ" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "a012345678" | "a012345678" | "ABCDEFGHIJ" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "0A12345678" | "0A12345678" | "ABCDEFGHIJ" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA123456789"| "aA123456789"| "ABCDEFGHIJ" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA123456789"| "aA123456789"| "5512345678" | ""          | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA123456789"| "aA123456789"| "5512345678" | null        | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "josdem" | "aA123456789"| "aA123456789"| "5512345678" | "ROLE_"     | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "12345"  | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "1234"   | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "123"    | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "12"     | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "josdem@email.com" | "J"      | "DLC"        | "Morales" | "1"      | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
    "josdem@email.com" | "remy@email.com"   | "J"      | "DLC"        | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678" | "ROLE_USER" | 'on'  || false
  }

}
