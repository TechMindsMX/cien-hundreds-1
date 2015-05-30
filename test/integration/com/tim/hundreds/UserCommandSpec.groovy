package com.tim.hundreds

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 */
class UserCommandSpec extends Specification {
  @Unroll
  void """When we have a user with email:  #email, emailCheck: #emailCheck, firstName: #firstName, middleName: #middleName, lastName: #lastName, username: #username, password: #password, passwordCheck: #passwordCheck, phone: #phone, we expect the result is: #result"""() {
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
    then:"We validate command"
      result == user.validate()
    where:"We have the next cases"
    email           | emailCheck      | firstName| middleName | lastName  | username | password     | passwordCheck | phone        || result
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678"  | "5512345678" || true
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678"  | null         || true
    "jos@gmail.com" | "jos@gmail.com" | "J"    | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678"  | null         || true
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "D"          | "Morales" | "josdem" | "aA12345678" | "aA12345678"  | null         || true
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "M"       | "josdem" | "aA12345678" | "aA12345678"  | null         || true
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "jos"    | "aA12345678" | "aA12345678"  | null         || true
  }

  @Unroll
   void """When we have a user with email: #email, emailCheck: #emailCheck, firstName: #firstName, middleName: #middleName, lastName: #lastName, username: #username, password: #password, passwordCheck: #passwordCheck, phone: #phone, we expect the result is: #result"""() {
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
    then:"We validate command"
      result == user.validate()
    where:"We have the next cases"
    email     | emailCheck        | firstName  | middleName   | lastName  | username | password     | passwordCheck | phone         || result
    null            | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678"  || false
    ""              | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678"  || false
    "josdem"        | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678"  || false
    "jos@gmail"     | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678"  || false
    "jos@gmail.com" | "jos@gmail.com" | null   | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678"  || false
    "jos@gmail.com" | "jos@gmail.com" | ""     | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678"  || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | null         | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678"  || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | ""           | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "5512345678"  || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | null      | "josdem" | "aA12345678" | "aA12345678" | "5512345678"  || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | ""        | "josdem" | "aA12345678" | "aA12345678" | "5512345678"  || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | null     | "aA12345678" | "aA12345678" | "5512345678"  || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | ""       | "aA12345678" | "aA12345678" | "5512345678"  || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | null         | "aA12345678" | "5512345678"  || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | ""           | "aA12345678" | "5512345678"  || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678" | ""            || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "1"           || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "55123456789" || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "551234567"   || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678" | "ABCDEFGHIJ"  || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "12345678"   | "12345678"   | "ABCDEFGHIJ"  || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "a012345678" | "a012345678" | "ABCDEFGHIJ"  || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "0A12345678" | "0A12345678" | "ABCDEFGHIJ"  || false
    "jos@gmail.com" | "jos@gmail.com" | "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA123456789"| "aA123456789"| "ABCDEFGHIJ"  || false
  }

}
