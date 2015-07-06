package com.tim.hundreds

import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder
import grails.converters.JSON

@Transactional
class RestService {
  def rest = new RestBuilder()

  def sendCommand(MessageCommand message, String url){
    try{
      log.info "email url: ${url}"
      def resp = rest.post(url){
        contentType "application/vnd.org.jfrog.artifactory.security.Group+json"
        body message
      }
    } catch(Exception ex) {
      log.warn "Error: ${ex.message}"
      throw new BusinessException(ex.message, ex)
      redirect action:'index'
    }
  }

}
