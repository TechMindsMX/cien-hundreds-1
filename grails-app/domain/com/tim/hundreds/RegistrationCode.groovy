package com.tim.hundreds

class RegistrationCode {
  String token = TokenService.generateToken()
  String email

  Date dateCreated

  RegistrationCodeStatus status = RegistrationCodeStatus.VALID

  static mapping = {
    version false
  }

}
