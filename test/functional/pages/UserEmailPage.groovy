package page
import geb.Page

class UserEmailPage extends Page {

    static url = "userEmail/create"
    static at = { title == "100Hundreds" }

    static content = {
        userEmailForm { $('#userEmail') }
        submitButton  { userEmailForm.find('.save') }
        cancelButton  { $("#btnCancel") }
        user          { $("#user") }
        type          { $("#type")}
        logout        { $('.nav-header').find('.logout') }
    }

}
