package page

import geb.Page

class LogoutPage extends Page {

  static url = "logout/index"

  static at = { driver.currentUrl.contains('login/auth') }

  static content = {

  }
}