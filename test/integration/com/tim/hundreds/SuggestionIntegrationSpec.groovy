package com.tim.hundreds

import spock.lang.Specification
import grails.validation.ValidationException

/**
 *
 */
class SuggestionIntegrationSpec extends Specification {
  def suggestionService

  void "Should save an musician with suggestion"() {
    given: "An musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = Genre.TRANCE
      musician.hasManager = true
      musician.dateCreated = new Date()
      musician.lastUpdated = new Date()
      musician.formed = new Date()
    and: "A user"
      def user = new User(username:'josdem',password:'password')
      def profile = new Profile(email:'josdem@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
      user.profile = profile
      user.save(flush: true)
    and: "We add musician to user"
      user.addToMusicians(musician)
      user.save()
    and: "We create a suggestion"
      def suggestionInstance = new Suggestion(name:'name',contactName:'contactName',email:'josdem@email.com',phone:'1234567890')
      suggestionInstance.musician = musician
    when: "We save suggestion"
      def result = suggestionService.save(suggestionInstance)
    then:"We validate command"
      result
    cleanup:"We delete musician"
      user.delete()
  }

  void "Should not save an musician with more than 3 suggestions"() {
    given: "An musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = Genre.TRANCE
      musician.hasManager = true
      musician.dateCreated = new Date()
      musician.lastUpdated = new Date()
      musician.formed = new Date()
    and: "A user"
      def user = new User(username:'josdem',password:'password')
      def profile = new Profile(email:'josdem@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
      user.profile = profile
      user.save(flush: true)
    and: "We add musician to user"
      user.addToMusicians(musician)
      user.save()
    and: "We create an suggestion"
      def suggestionInstance1 = new Suggestion(name:'name',contactName:'contactName',email:'josdem@email.com',phone:'1234567890')
      suggestionInstance1.musician = musician
      def suggestionInstance2 = new Suggestion(name:'name',contactName:'contactName',email:'josdem@email.com',phone:'1234567890')
      suggestionInstance2.musician = musician
      def suggestionInstance3 = new Suggestion(name:'name',contactName:'contactName',email:'josdem@email.com',phone:'1234567890')
      suggestionInstance3.musician = musician
      def suggestionInstance4 = new Suggestion(name:'name',contactName:'contactName',email:'josdem@email.com',phone:'1234567890')
      suggestionInstance4.musician = musician
    when: "We save suggestion"
      suggestionService.save(suggestionInstance1)
      suggestionService.save(suggestionInstance2)
      suggestionService.save(suggestionInstance3)
      suggestionService.save(suggestionInstance4)
    then:"We expect exception"
      thrown ValidationException
    cleanup:"We delete musician"
      user.delete()
  }

}
