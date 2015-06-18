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
}
