package page
import geb.Page

class UserTelephonePage extends Page {

    static url = "userTelephone/create"

    static at = { driver.currentUrl.contains('userTelephone/create') }

    static content = {
        userTelephoneForm { $('#userTelephoneForm') }
        submitButton { userTelephoneForm.find('.save') }
        cancelButton { $("#btnCancel") }
        user         { $("#user") }
        type         { $("#type")}
        logout       { $('.nav-header').find('.logout') }
    }

}
