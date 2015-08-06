package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class ActivityService {

  def save(activityInstance) {
    def musician = activityInstance.musician
    musician.addToActivities(activityInstance)
    musician.save(failOnError:true)

    activityInstance
  }

  def saveActivity(activityInstance) {
  	if(activityInstance.musician){
      def musician = activityInstance.musician
      musician.addToAudios(activityInstance)
      musician.save failOnError: true
    }
    if(activityInstance.contact){
      def contact = activityInstance.contact
      contact.addToAudios(activityInstance)
      contact.save failOnError: true
    }
    activityInstance
  }
}
