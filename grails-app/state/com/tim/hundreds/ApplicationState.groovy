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

  static final Integer TIME_UNIT = 60;
  static final Integer MILISECONDS = 1000;
  static final Integer TIMEOUT = 20;

  static final String LOGO_DIRECTORY = '/.cienhundreds/logos/'
  static final String PHOTO_DIRECTORY = '/images/photos/'
  static final String RESUME_DIRECTORY = '/.cienhundreds/resumes/'

  static final String FORGOT_PASSWORD_URL = 'http://emailer.timone.mx/timone/services/email/forgotPassword'
  static final String FORGOT_USERNAME_URL = 'http://emailer.timone.mx/timone/services/email/forgotUsername'
  static final String REGISTER_URL = 'http://emailer.timone.mx/timone/services/email/register'
  static final String NEW_USER_URL = 'http://emailer.timone.mx/timone/services/email/newUser'
}
