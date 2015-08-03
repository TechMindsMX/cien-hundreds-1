package com.tim.hundreds

class modelContextService {

  def setParent(instance, params) {
    if (params.musicianUuid) { instance.musician = Musician.findByUuid(params.musicianUuid) }
    else if (params.companyUuid) { instance.company = Company.findByUuid(params.companyUuid) }
    else if (params.contactUuid) { instance.contact = Contact.findByUuid(params.contactUuid) }
    else if (params.datosFiscalesUuid) { instance.datosFiscales = Contact.findByUuid(params.datosFiscalesUuid) }
    else {
      throw new MissingParentException('Parent error')
    }

    instance
  }

  def getParamsForRedirectOnDelete(instance, request) {
    if (instance.musician) {
      request.controller = 'musician'
      request.uuid = instance.musician.uuid
    }
    else if (instance.company) {
      request.controller = 'company'
      request.uuid = instance.company.uuid
    }
    else if (instance.contact) {
      request.controller = 'contact'
      request.uuid = instance.contact.uuid
    }
    else if (instance.datosFiscales) {
      request.controller = 'datosFiscales'
      request.uuid = instance.datosFiscales.uuid
    }
    else {
      throw new MissingParentException('Parent error')
    }
  }
}