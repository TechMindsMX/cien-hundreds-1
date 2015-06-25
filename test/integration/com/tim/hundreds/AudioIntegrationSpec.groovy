package com.tim.hundreds

import spock.lang.Specification
import spock.lang.Shared
import grails.validation.ValidationException

class AudioIntegrationSpec extends Specification {
  def audioService

  void "Should save an musician with audio"() {
  given: "Musician"
    def musician = new Musician(name:'name',history:'history')
    musician.genre = new Genre(name: 'Trance').save()
    musician.hasManager = true
    musician.dateCreated = new Date()
    musician.lastUpdated = new Date()
    musician.formed = new Date()

    def user = new User(username:'josdemAudioIntegration',password:'password')
    def profile = new Profile(email:'josdemAudioIntegration@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
    user.profile = profile
    user.addToMusicians(musician)
    user.save flush: true
    and: "An audio"
      def audioInstance = new Audio(url:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance.musician = musician
    when: "We save audio"
      def result = audioService.saveAudio(audioInstance)
    then:"We validate audio"
      result
    cleanup: "Delete user"
    user.delete()
  }

  void "Should not save an musician with more than 5 audios"() {
    given: "Musician"
    def musician = new Musician(name:'name',history:'history')
    musician.genre = new Genre(name: 'Trance').save()
    musician.hasManager = true
    musician.dateCreated = new Date()
    musician.lastUpdated = new Date()
    musician.formed = new Date()

    def user = new User(username:'josdemAudioIntegration1',password:'password')
    def profile = new Profile(email:'josdemAudioIntegration1@email.com', firstName:'me', middleName:'middleName', lastName:'lastName')
    user.profile = profile
    user.addToMusicians(musician)
    user.save flush: true
    and: "Some audios"
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
    cleanup:"Deleteuser"
      user.delete()
  }

}
