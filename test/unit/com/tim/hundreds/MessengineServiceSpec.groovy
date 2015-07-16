package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MessengineService)
class MessengineServiceSpec extends Specification {
  def restService = Mock(RestService)

  def setup() {
    service.restService = restService
    grailsApplication.config.musician.edited.user.url >> 'editedUrl'
  }

  void "should send an edited message to musician user"() {
  given:"And Musician"
    def musician = Mock(Musician)
    def user = Mock(User)
    def profile = Mock(Profile)
  when:"We send an message"
    musician.user >> user
    user.profile >> profile
  then:"We expect message was sent"
    restService.sendCommand(_ as AssignationCommand, 'editedUrl')
  }
}
