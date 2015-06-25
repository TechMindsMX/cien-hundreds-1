package com.tim.hundreds

import spock.lang.Specification
import grails.validation.ValidationException

/**
 *
 */
class VideoIntegrationSpec extends Specification {

  def videoService

  void "Should save an musician with video"() {
    given: "An musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = new Genre(name: 'Trance').save()
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
    and: "We create an Video"
      def videoInstance = new Video(url:'https://www.youtube.com/watch?v=LKckM5gq7VU')
      videoInstance.musician = musician
    when: "We save video"
      def result = videoService.saveVideo(videoInstance)
    then:"We validate command"
      result
    cleanup:"We delete musician"
      user.delete()
  }

  void "Should not save an musician with more than 5 videos"() {
    given: "An musician"
      def musician = new Musician(name:'name',history:'history')
      musician.genre = new Genre(name: 'Trance').save()
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
    and: "We create an Video"
      def videoInstance1 = new Video(url:'https://www.youtube.com/watch?v=LKckM5gq7VU')
      videoInstance1.musician = musician
      def videoInstance2 = new Video(url:'https://www.youtube.com/watch?v=LKckM5gq7VU')
      videoInstance2.musician = musician
      def videoInstance3 = new Video(url:'https://www.youtube.com/watch?v=LKckM5gq7VU')
      videoInstance3.musician = musician
      def videoInstance4 = new Video(url:'https://www.youtube.com/watch?v=LKckM5gq7VU')
      videoInstance4.musician = musician
      def videoInstance5 = new Video(url:'https://www.youtube.com/watch?v=LKckM5gq7VU')
      videoInstance5.musician = musician
      def videoInstance6 = new Video(url:'https://www.youtube.com/watch?v=LKckM5gq7VU')
      videoInstance6.musician = musician
    when: "We save video"
      videoService.saveVideo(videoInstance1)
      videoService.saveVideo(videoInstance2)
      videoService.saveVideo(videoInstance3)
      videoService.saveVideo(videoInstance4)
      videoService.saveVideo(videoInstance5)
      videoService.saveVideo(videoInstance6)
    then:"We expect exception"
      thrown ValidationException
    cleanup:"We delete musician"
      user.delete()
  }

}
