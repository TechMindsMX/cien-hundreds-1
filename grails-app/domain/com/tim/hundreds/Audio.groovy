package com.tim.hundreds

class Audio {
  String uuid = TokenGenerator.generateToken()
  String url

  static belongsTo = [
    musician : Musician
  ]

  static constraints = {
    url(blank:false,size:10..100,matches: /^https?:\/\/(?:www\.)?soundcloud\.com\/[A-Za-z0-9]+(?:[-_][A-Za-z0-9]+)*(?!\/sets(?:\/|$))(?:\/[A-Za-z0-9]+(?:[-_][A-Za-z0-9]+)*){1,2}\/?$/
      )
	}
}
