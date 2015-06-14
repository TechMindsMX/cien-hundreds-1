package com.tim.hundreds

import grails.transaction.Transactional

@Transactional
class DatosFiscalesContextService {
  def datosFiscalesService

  def saveInstance(datosFiscalesInstance, params) {
    if(params.musicianId){
      def musician = Musician.findById(params.musicianId)
      datosFiscalesService.saveDatosFiscalesToInstance(datosFiscalesInstance, musician)
    }
    if(params.companyId){
      def company = Company.findById(params.companyId)
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
