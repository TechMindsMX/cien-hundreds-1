package page

import geb.Page

class BusinessActivityPage extends Page {

    static url = "businessActivity/create"

    static at = { driver.currentUrl.contains('businessActivity/create') }

    static content = {
        businessActivityForm { $('#businessActivityForm') }
        submitButton         { businessActivityForm.find('.save') }
        cancelButton         { $("#btnCancel") }
        logout               { $('#navbar').find('.logout') }
    }
}
