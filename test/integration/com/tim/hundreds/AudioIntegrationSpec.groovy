package com.tim.hundreds

import spock.lang.Specification
import spock.lang.Shared
import grails.validation.ValidationException

class AudioIntegrationSpec extends Specification {
  def audioService
  @Shared user
  @Shared musician

  def setupSpec(){
    musician = new Musician(name:'name',history:'history')
    musician.genre = Genre.TRANCE
    musician.hasManager = true
    musician.dateCreated = new Date()
    musician.lastUpdated = new Date()
    musician.formed = new Date()

    user = new User(username:'josdemAudioIntegration',password:'password')
    def profile = new Profile(email:'josdemAudioIntegration@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
    user.profile = profile
    user.addToMusicians(musician)
    user.save flush: true
  }

  void "Should save an musician with audio"() {
    given: "An audio"
      def audioInstance = new Audio(url:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance.musician = musician
      assert User.count == 1
    when: "We save audio"
      def result = audioService.saveAudio(audioInstance)
    then:"We validate audio"
      result
  }

  void "Should not save an musician with more than 5 audios"() {
    given: "Some audios"
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
      assert User.count == 1
    when: "We save audio"
      audioService.saveAudio(audioInstance1)
      audioService.saveAudio(audioInstance2)
      audioService.saveAudio(audioInstance3)
      audioService.saveAudio(audioInstance4)
      audioService.saveAudio(audioInstance5)
      audioService.saveAudio(audioInstance6)
    then:"We expect exception"
        thrown ValidationException
  }

  def cleanupSpec(){
    user.delete()
  }

}
