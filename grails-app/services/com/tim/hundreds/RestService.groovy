package com.tim.hundreds

import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder
import grails.converters.JSON

@Transactional
class RestService {
  def rest = new RestBuilder()

  def send(MessageCommand message){
    def resp = rest.post(ApplicationState.FORGOT_PASSWORD_URL){
      contentType "application/vnd.org.jfrog.artifactory.security.Group+json"
      body message
    }
    log.info "resp: ${resp.dump()}"
  }
}
