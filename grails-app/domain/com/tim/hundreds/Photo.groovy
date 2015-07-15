package com.tim.hundreds

class Photo implements Comparable {
  String uuid = TokenGenerator.generateToken()
  String path

  Date dateCreated
  Date lastUpdated

  static belongsTo = [
    musician : Musician
  ]

  static constraints = {
    path blank:false,size:36..36
  }

	int compareTo(obj) {
		dateCreated.compareTo(obj.dateCreated)
	}

}
