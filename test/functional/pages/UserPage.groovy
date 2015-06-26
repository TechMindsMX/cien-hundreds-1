package page

import geb.Page

class UserPage extends Page {

  static url = "user/create"

  static at = { title == "100Hundreds" }

  static content = {
    userForm { $("#userForm") }
  }
}
