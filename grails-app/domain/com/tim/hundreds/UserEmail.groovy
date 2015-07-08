package com.tim.hundreds

class UserEmail {
 String uuid = TokenGenerator.generateToken()
 String address
 EmailType type

 static belongsTo = [ user: User ]

 static constraints = {
   address blank:false,email:true,size:6..200
 }

}
