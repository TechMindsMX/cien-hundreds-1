package com.tim.hundreds

import spock.lang.Specification
import spock.lang.Shared
import grails.validation.ValidationException

class UserIntegrationSpec extends Specification {

  void "Should not register other user when we want to use an taken email"() {
    given: "An user"
      def user = new User(username:'userIntegrationSpec1',password:'password')
      def profile = new Profile(email:'userIntegrationSpec@email.com', firstName:'me', motherLastName:'motherLastName', lastName:'lastName')
      user.profile = profile
      user.save flush: true
    and: "Other user"
      def other = new User(username:'userIntegrationSpec2',password:'password')
      profile = new Profile(email:'userIntegrationSpec@email.com', firstName:'user', motherLastName:'otherMiddleName', lastName:'otherLastName')
      other.profile = profile
    when: "We save other user"
      other.save flush: true
    then:"We expect only one user"
      user.id > 0
      !other.id
    cleanup:"Deleting user"
      user.delete flush: true
  }

}
