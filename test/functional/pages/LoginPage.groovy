package page

import geb.Page

class LoginPage extends Page {

  static url = "login/auth"

  static at = { driver.currentUrl.contains('login/auth') }

  static content = {
    loginForm { $("#loginForm") }
    loginButton { $("#btn-success") }
    registerLink { $("a[href*='register/index']") }
  }
}
