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
      musician.addToActivities(activityInstance)
      musician.save failOnError: true
    }
    if(activityInstance.contact){
      def contact = activityInstance.contact
      contact.addToActivities(activityInstance)
      contact.save failOnError: true
    }
    activityInstance
  }
  def resolveMusician(activityInstance) {
    if(activityInstance.musician){
      return activityInstance.musician
    }
    if (activityInstance.contact){
      return activityInstance.contact.musician
    }
  }
}
