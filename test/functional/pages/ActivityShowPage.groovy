package page

import geb.Page

class ActivityShowPage extends Page {

    static url = "activity/show"

    static at = { driver.currentUrl.contains('activity/show') }

    static content = {
		alertSuccess (required:false) { $('.alert-info') }
		alertErrors (required:false) { $('.alert-danger') }

        backToMusician { $('a[href*="musician/show"]') }

        submitButton { $('.edit') }
        cancelButton { $("#btnCancel") }
        logout       { $('#navbar').find('.logout') }
    }
}
