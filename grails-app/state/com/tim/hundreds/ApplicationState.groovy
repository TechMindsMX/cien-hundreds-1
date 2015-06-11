package com.tim.hundreds

interface ApplicationState {
  static final Integer MAX_AUDIOS = 5
  static final Integer MAX_VIDEOS = 5
  static final Integer MAX_PHOTOS = 5
  static final Integer MAX_SUGGESTIONS = 3
  static final Integer MAX_TELEPHONES = 3
  static final Integer MAX_EMAILS = 3
  static final Integer MAX_REFERENCES = 3
  static final Integer MAX_EVENTS = 1000
  static final Integer MAX_COLLABORATORS = 1000
  static final Integer MAX_PRODUCTS = 1000
  static final Integer MAX_CONTACTS = 1000
  static final Integer MAX_ACTIVITIES = 1000
  static final Integer MAX_COMPLEMENTS = 1000

  static final String IMAGE_EXTENSION = '.png'
  static final String RESUME_EXTENSION = '.pdf'

  static final String FORGOT_PASSWORD_URL = 'http://localhost:8082/web/services/email/forgotPassword'
  static final String REGISTER_URL = 'http://localhost:8082/web/services/email/register'
}
