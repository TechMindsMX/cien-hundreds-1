package page
import geb.Page

class UserTelephonePage extends Page {

    static url = "userTelephone/create"
    static at = { title == "100Hundreds" }

    static content = {
        userTelephoneForm { $('#userTelephoneForm') }
        submitButton { userTelephoneForm.find('.save') }
        cancelButton { $("#btnCancel") }
        user         { $("#user") }
        type         { $("#type")}
        logout       { $('.nav-header').find('.logout') }
    }

}
