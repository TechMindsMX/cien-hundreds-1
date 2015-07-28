package com.tim.hundreds

class Audio {
  String uuid = TokenGenerator.generateToken()
  String url

  static belongsTo = [
    musician : Musician
  ]

  static constraints = {
    url(blank:false,size:10..100,matches: /^https?:\/\/(?:www\.)?soundcloud\.com\/[\w#!:.?+=&%@!\-\/]+/
      )
	}
}
