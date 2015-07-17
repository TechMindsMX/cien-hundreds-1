package page

import geb.Page

class ActivityShowPage extends Page {

    static url = "activity/show"

    static at = { driver.currentUrl.contains('activity/show') }

    static content = {
        backToMusician { $('a[href*="musician/show"]') }

        submitButton { $('.edit') }
        cancelButton { $("#btnCancel") }
        logout       { $('.nav-header').find('.logout') }
    }
}
