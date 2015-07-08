package com.tim.hundreds

class CollaboratorEmail {
	String uuid = TokenGenerator.generateToken()
	String address
	EmailType type

	static belongsTo = [ collaborator: Collaborator ]

    static constraints = {
	    address blank:false,email:true,size:6..200
    }
}
