package page

import geb.Page

class BusinessActivityPage extends Page {

    static url = "businessActivity/create"

    static at = { title == "100Hundreds" }

    static content = {
        businessActivityForm { $('#businessActivityForm') }
        submitButton         { businessActivityForm.find('.save') }
        cancelButton         { $("#btnCancel") }
        logout               { $('.nav-header').find('.logout') }
    }
}
