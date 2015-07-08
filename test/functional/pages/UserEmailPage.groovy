package page
import geb.Page

class UserEmailPage extends Page {

    static url = "userEmail/create"

    static at = { driver.currentUrl.contains('userEmail/create') }

    static content = {
        userEmailForm { $('#userEmail') }
        submitButton  { userEmailForm.find('.save') }
        cancelButton  { $("#btnCancel") }
        user          { $("#user") }
        type          { $("#type")}
        logout        { $('.nav-header').find('.logout') }
    }

}
