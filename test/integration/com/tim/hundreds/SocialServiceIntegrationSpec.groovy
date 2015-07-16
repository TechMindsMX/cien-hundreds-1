package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification

class SocialServiceIntegrationSpec extends Specification {
  def socialService

  void "Should save socialInstance to musician"() {
    given: "An instance"
      def instance = new Musician(name:'name',history:'history')
      instance.genre = new Genre(name: 'Trance').save()
      instance.hasManager = true
      instance.dateCreated = new Date()
      instance.lastUpdated = new Date()
      instance.formed = new Date()
    and: "Above & Beyond twitter"
      def twitterAboveAndBeyond = 'https://twitter.com/aboveandbeyond'
    and: "We save instance"
      instance.save(flush: true)
    and: "We create an socialInstance"
      def socialInstance = new Social(twitter:twitterAboveAndBeyond)
    when: "We save to instance"
      def result = socialService.saveSocialToInstance(socialInstance, instance)
    then: "We expect same social"
      result.social
      result.social.twitter == twitterAboveAndBeyond
  }

  void "Should save socialInstance to contact"() {
    given: "An instance"
      def instance = new Contact(firstName:'firstName',motherLastName:'motherLastName',lastName:'lastName')
      instance.type = GenderType.MALE
      instance.role = new MusicianRole(name: 'Manager').save()
      instance.birthDate = new Date()
      instance.entryDate = new Date()
    and: "Above & Beyond twitter"
      def twitter = 'https://twitter.com/firstName'
    and: "We save instance"
      instance.save(flush: true)
    and: "We create an socialInstance"
      def socialInstance = new Social(twitter:twitter)
    when: "We save to instance"
      def result = socialService.saveSocialToInstance(socialInstance, instance)
    then: "We expect same social"
      result.social
      result.social.twitter == twitter
  }

  void "Should save socialInstance to company"() {
    given: "An instance"
      def instance = new Company(name:'Anjunabeats',description:'Music Production')
      instance.type = new BusinessActivity(name:'Products')
    and: "Twitter account"
      def twitter = 'https://twitter.com/Anjunabeats'
    and: "We save instance"
      instance.save(flush: true)
    and: "We create an socialInstance"
      def socialInstance = new Social(twitter:twitter)
    when: "We save to instance"
      def result = socialService.saveSocialToInstance(socialInstance, instance)
    then: "We expect same social"
      result.social
      result.social.twitter == twitter
  }
}
