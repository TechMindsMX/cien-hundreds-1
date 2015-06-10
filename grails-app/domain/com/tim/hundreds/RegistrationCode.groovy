package com.tim.hundreds

class RegistrationCode {

  String token = UUID.randomUUID().toString().replaceAll('-', '')
  String email

  Date dateCreated

  RegistrationCodeStatus status = RegistrationCodeStatus.VALID

  static mapping = {
    version false
  }

}
