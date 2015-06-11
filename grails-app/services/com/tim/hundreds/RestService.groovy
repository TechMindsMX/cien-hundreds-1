package com.tim.hundreds

import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder
import grails.converters.JSON

@Transactional
class RestService {
  def rest = new RestBuilder()

  def sendCommand(MessageCommand message, String url){
    try{
      def resp = rest.post(url){
        contentType "application/vnd.org.jfrog.artifactory.security.Group+json"
        body message
      }
      log.info "resp: ${resp.dump()}"
    } catch(Exception ex) {
      log.info "Error: ${ex.message}"
      flash.error = "El servicio de correo no esta disponible"
      redirect action:'index'
    }
  }

}
