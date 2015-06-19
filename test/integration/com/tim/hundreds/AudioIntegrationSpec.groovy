package com.tim.hundreds

import spock.lang.Specification
import grails.validation.ValidationException

class AudioIntegrationSpec extends Specification {
  def audioService

  void "Should save an musician with audio"() {
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
    and: "We create an audio"
      def audioInstance = new Audio(url:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance.musician = musician
    when: "We save audio"
      def result = audioService.saveAudio(audioInstance)
    then:"We validate audio"
      result
    cleanup:"We delete musician"
      user.delete()
  }

  void "Should not save an musician with more than 5 audios"() {
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
    and: "We create an Audio"
      def audioInstance1 = new Audio(url:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance1.musician = musician
      def audioInstance2 = new Audio(url:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance2.musician = musician
      def audioInstance3 = new Audio(url:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance3.musician = musician
      def audioInstance4 = new Audio(url:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance4.musician = musician
      def audioInstance5 = new Audio(url:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance5.musician = musician
      def audioInstance6 = new Audio(url:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance6.musician = musician
    when: "We save audio"
      audioService.saveAudio(audioInstance1)
      audioService.saveAudio(audioInstance2)
      audioService.saveAudio(audioInstance3)
      audioService.saveAudio(audioInstance4)
      audioService.saveAudio(audioInstance5)
      audioService.saveAudio(audioInstance6)
    then:"We expect exception"
        thrown ValidationException
    cleanup:"We delete musician"
      user.delete()
  }

}
