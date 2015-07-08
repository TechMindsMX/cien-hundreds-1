package com.tim.hundreds

class CollaboratorTelephone {
	String uuid = TokenGenerator.generateToken()
	String phone
	TelephoneType type

	static belongsTo = [ collaborator: Collaborator ]

	static constraints = {
	phone nullable:true,blank:false,matches:/^[0-9]*$/,size:10..10
	}
}
