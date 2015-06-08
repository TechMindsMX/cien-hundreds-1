package com.tim.hundreds

import spock.lang.Specification
import grails.validation.ValidationException

/**
 *
 */
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
    and: "We save musician"
      musician.save(flush: true)
    and: "We create an Audio"
      def audioInstance = new Audio(link:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance.musician = musician
    when: "We save video"
      def result = audioService.saveAudio(audioInstance)
    then:"We validate command"
      result
    cleanup:"We delete musician"
      musician.delete()
  }

  void "Should not save an musician with more than 5 audios"() {
    given: "An musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = Genre.TRANCE
      musician.hasManager = true
      musician.dateCreated = new Date()
      musician.lastUpdated = new Date()
      musician.formed = new Date()
    and: "We save musician"
      musician.save(flush: true)
    and: "We create an Audio"
      def audioInstance1 = new Audio(link:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance1.musician = musician
      def audioInstance2 = new Audio(link:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance2.musician = musician
      def audioInstance3 = new Audio(link:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance3.musician = musician
      def audioInstance4 = new Audio(link:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance4.musician = musician
      def audioInstance5 = new Audio(link:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
      audioInstance5.musician = musician
      def audioInstance6 = new Audio(link:'https://soundcloud.com/aboveandbeyond/all-over-the-world-feat-alex-vargas')
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
      musician.delete()
  }

}
