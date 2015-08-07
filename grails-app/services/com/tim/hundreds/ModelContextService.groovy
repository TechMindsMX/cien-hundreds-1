package com.tim.hundreds

class ModelContextService {

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

  String getInstanceFromChild(child){
    if(child.company) child.company.class.getSimpleName().toString().toLowerCase()
    else if(child.musician) child.musician.class.getSimpleName().toString().toLowerCase()
    else if(child.contact) child.contact.class.getSimpleName().toString().toLowerCase()
    else {
      throw new MissingParentException('Parent error')
    }
  }

  def getParamsForRedirectOnDelete(instance, request) {
    List models = ['musician', 'company', 'contact', 'datosFiscales']
    models.each {
      if(instance.hasProperty(it) ){
        if (instance."${it}") {
          request.controller = it
          request.uuid = instance."${it}".uuid
        }
      }
    }
    if (!request.controller || !request.uuid) {
      throw new MissingParentException('Parent error')
    }
  }

}
