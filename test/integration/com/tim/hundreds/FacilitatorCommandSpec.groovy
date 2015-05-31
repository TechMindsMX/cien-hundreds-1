package com.tim.hundreds

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 */
class FacilitatorCommandSpec extends Specification {
  @Unroll
  void """When we have a user with firstName: #firstName, middleName: #middleName, lastName: #lastName, username: #username, password: #password, passwordCheck: #passwordCheck, role: #role, we expect the result is: #result"""() {
    given: "An user"
      FacilitatorCommand user = new FacilitatorCommand()
    when: "We assing values to command"
      user.firstName = firstName
      user.middleName = middleName
      user.lastName = lastName
      user.username = username
      user.password = password
      user.passwordCheck = passwordCheck
      user.role = role
    then:"We validate command"
      result == user.validate()
    where:"We have the next cases"
    firstName| middleName | lastName  | username | password     | passwordCheck | role               || result
    "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678"  | "ROLE_FACILITATOR" || true
    "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678"  | "ROLE_FACILITATOR" || true
    "J"    | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678"  | "ROLE_FACILITATOR" || true
    "Jose" | "D"          | "Morales" | "josdem" | "aA12345678" | "aA12345678"  | "ROLE_FACILITATOR" || true
    "Jose" | "De la Cruz" | "M"       | "josdem" | "aA12345678" | "aA12345678"  | "ROLE_FACILITATOR" || true
    "Jose" | "De la Cruz" | "Morales" | "jos"    | "aA12345678" | "aA12345678"  | "ROLE_FACILITATOR" || true
  }

  @Unroll
   void """When we have a user with firstName: #firstName, middleName: #middleName, lastName: #lastName, username: #username, password: #password, passwordCheck: #passwordCheck, role: #role, we expect the result is: #result"""() {
    given: "An user"
      FacilitatorCommand user = new FacilitatorCommand()
    when: "We assing values to command"
      user.firstName = firstName
      user.middleName = middleName
      user.lastName = lastName
      user.username = username
      user.password = password
      user.passwordCheck = passwordCheck
      user.role = role
    then:"We validate command"
      result == user.validate()
    where:"We have the next cases"
    firstName| middleName | lastName  | username | password     | passwordCheck | role               || result
    null   | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678"  | "ROLE_FACILITATOR" || false
    ""     | "De la Cruz" | "Morales" | "josdem" | "aA12345678" | "aA12345678"  | "ROLE_FACILITATOR" || false
    "Jose" | null         |"Morales"  | "josdem" | "aA12345678" | "aA12345678"  | "ROLE_FACILITATOR" || false
    "Jose" | ""           | "Morales" | "josdem" | "aA12345678" | "aA12345678"  | "ROLE_FACILITATOR" || false
    "Jose" | "De la Cruz" | null      | "josdem" | "aA12345678" | "aA12345678"  | "ROLE_FACILITATOR" || false
    "Jose" | "De la Cruz" | ""        | "josdem" | "aA12345678" | "aA12345678"  | "ROLE_FACILITATOR" || false
    "Jose" | "De la Cruz" | "Morales" | null     | "aA12345678" | "aA12345678"  | "ROLE_FACILITATOR" || false
    "Jose" | "De la Cruz" | "Morales" | ""       | "aA12345678" | "aA12345678"  | "ROLE_FACILITATOR" || false
    "Jose" | "De la Cruz" | "Morales" | "josdem" | null         | "aA12345678"  | "ROLE_FACILITATOR" || false
    "Jose" | "De la Cruz" | "Morales" | "josdem" | ""           | "aA12345678"  | "ROLE_FACILITATOR" || false
    "Jose" | "De la Cruz" | "Morales" | "josdem" | "12345678"   | "12345678"    | "ROLE_FACILITATOR" || false
    "Jose" | "De la Cruz" | "Morales" | "josdem" | "a012345678" | "a012345678"  | "ROLE_FACILITATOR" || false
    "Jose" | "De la Cruz" | "Morales" | "josdem" | "0A12345678" | "0A12345678"  | "ROLE_FACILITATOR" || false
    "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA123456789"| "aA123456789" | null               || false
    "Jose" | "De la Cruz" | "Morales" | "josdem" | "aA123456789"| "aA123456789" | ""                 || false
  }

}
