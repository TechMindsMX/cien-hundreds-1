package com.tim.hundreds

class Audio {
  String uuid = TokenGenerator.generateToken()
  String url

  Date dateCreated
  Date lastUpdated

  static belongsTo = [
    musician : Musician, contact: Contact
  ]

  static constraints = {
    url(blank:false,size:10..100,matches: /^https?:\/\/(?:www\.)?soundcloud\.com\/[\w#!:.?+=&%@!\-\/]+/
      )
    musician nullable:true
    contact nullable:true
	}
}
