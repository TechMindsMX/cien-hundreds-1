package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class ActivityService {

  def save(activityInstance) {
    log.info "Activity count by user: ${Activity.findByMusician(activityInstance.musician)?.count()}"

    def musician = activityInstance.musician
    musician.addToActivities(activityInstance)
    musician.save(failOnError:true)

    activityInstance
  }
}
