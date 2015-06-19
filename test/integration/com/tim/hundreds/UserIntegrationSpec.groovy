package com.tim.hundreds

import spock.lang.Specification
import spock.lang.Shared
import grails.validation.ValidationException

class UserIntegrationSpec extends Specification {
  @Shared user

  def setupSpec(){
    user = new User(username:'josdem',password:'password')
    def profile = new Profile(email:'josdem@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
    user.profile = profile
    user.save flush: true
    assert user.id
  }

  void "Should not register other user when we want to use an taken email"() {
    given: "An user"
      def other = new User(username:'user',password:'password')
      def profile = new Profile(email:'josdem@email.com', firstName:'user', middleName:'otherMiddleName', lastName:'otherLastName')
      other.profile = profile
    when: "We save other user"
      other.save flush: true
    then:"We expect only one user"
       User.count() == 1
  }

  def cleanupSpec(){
    user.delete()
  }

}
