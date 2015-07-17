package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MessengineService)
class MessengineServiceSpec extends Specification {
  def restService = Mock(RestService)

  def setup() {
    service.restService = restService
    grailsApplication.config.musician.edited.user.url = 'editedMusicianUrl'
    grailsApplication.config.company.edited.user.url = 'editedCompanyUrl'
  }

  void "should send an edited message to musician user"() {
  given:"And Musician"
    def musician = Mock(Musician)
    def user = Mock(User)
    def assigned = Mock(User)
    def userProfile = Mock(userProfile)
  when:"We send an message"
    musician.user >> user
    user.profile >> userProfile
    assigned.profile >> targetProfile
    service.sendInstanceEditedMessage(musician, 'musician')
  then:"We expect message was sent"
    2 * restService.sendCommand(_ as AssignationCommand, 'editedMusicianUrl')
  }

  void "should not send an edited message to facilitator"() {
  given:"And Musician"
    def musician = Mock(Musician)
    def user = Mock(User)
    def assigned = Mock(User)
    def userProfile = Mock(userProfile)
  when:"We send an message"
    musician.user >> user
    user.profile >> userProfile
    assigned.profile >> null
    service.sendInstanceEditedMessage(musician, 'musician')
  then:"We expect message was sent"
    1 * restService.sendCommand(_ as AssignationCommand, 'editedMusicianUrl')
  }


  void "should send an edited message to company user"() {
  given:"And Musician"
    def company = Mock(Company)
    def user = Mock(User)
    def assigned = Mock(User)
    def userProfile = Mock(userProfile)
  when:"We send an message"
    company.user >> user
    user.profile >> userProfile
    assigned.profile >> targetProfile
    service.sendInstanceEditedMessage(company, 'company')
  then:"We expect message was sent"
    2 * restService.sendCommand(_ as AssignationCommand, 'editedCompanyUrl')
  }

  void "should not send an edited message to buyer"() {
  given:"And Musician"
    def company = Mock(Company)
    def user = Mock(User)
    def assigned = Mock(User)
    def userProfile = Mock(userProfile)
  when:"We send an message"
    company.user >> user
    user.profile >> userProfile
    assigned.profile >> null
    service.sendInstanceEditedMessage(company, 'company')
  then:"We expect message was sent"
    1 * restService.sendCommand(_ as AssignationCommand, 'editedCompanyUrl')
  }


}
