package page

import geb.Page

class UserPage extends Page {

  static url = "user/create"

  static at = { driver.currentUrl.contains('user/create') }

  static content = {
    userForm { $("#userForm") }
  }
}
