package com.tim.hundreds

import spock.lang.Specification
import spock.lang.Shared
import grails.validation.ValidationException

class UserIntegrationSpec extends Specification {
  @Shared user

  def setupSpec(){
    user = new User(username:'josdemUserIntegrationSpec',password:'password')
    def profile = new Profile(email:'josdemUserIntegrationSpec@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
    user.profile = profile
    user.save flush: true
  }

  void "Should not register other user when we want to use an taken email"() {
    given: "An user"
      def other = new User(username:'user',password:'password')
      def profile = new Profile(email:'josdemUserIntegrationSpec@email.com', firstName:'user', middleName:'otherMiddleName', lastName:'otherLastName')
      other.profile = profile
    when: "We save other user"
      other.save flush: true
    then:"We expect only one user"
       user.id > 0
       !other.id
  }

  def cleanupSpec(){
    user.delete()
  }

}
