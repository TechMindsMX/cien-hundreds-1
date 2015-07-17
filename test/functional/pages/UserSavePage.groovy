package page

import geb.Page

class UserSavePage extends Page {

  static url = "user/save"

  static at = { driver.currentUrl.contains('user/save') }

  static content = {
    userForm { $("#userForm") }

    alertErrors { $('.alert-danger') }
  }
}
