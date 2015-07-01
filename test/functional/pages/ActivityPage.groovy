package page

import geb.Page

class ActivityPage extends Page {

    static url = "activity/create"

    static at = { title == "100Hundreds" }

    static content = {
        activityForm { $('#activityForm') }
        submitButton { activityForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('.nav-header').find('.logout') }
    }
}
