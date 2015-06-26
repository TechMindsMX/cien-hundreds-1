package page

import geb.Page

class LoginPage extends Page {

  static url = "login/auth"

  static at = { title == "100Hundreds" }

  static content = {
    loginForm { $("#loginForm") }
    loginButton { $("#loginButton") }
    registerLink { $("a[href*='register/index']") }
  }
}
