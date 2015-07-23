package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class DatosFiscalesContextService {
  def datosFiscalesService

  def saveInstance(datosFiscalesInstance, params) {
    if(params.musician?.id){
      def musician = Musician.findById(params.musician.id)
      datosFiscalesService.saveDatosFiscalesToInstance(datosFiscalesInstance, musician)
    }
    if(params.company?.id){
      def company = Company.findById(params.company.id)
      datosFiscalesService.saveDatosFiscalesToInstance(datosFiscalesInstance, company)
    }
  }

  def deleteInstance(datosFiscalesInstance) {
    def musician = Musician.findByDatosFiscales(datosFiscalesInstance)
    datosFiscalesService.deleteDatosFiscalesFromInstance(datosFiscalesInstance, musician)

    def company = Company.findByDatosFiscales(datosFiscalesInstance)
    datosFiscalesService.deleteDatosFiscalesFromInstance(datosFiscalesInstance, company)
  }

}
