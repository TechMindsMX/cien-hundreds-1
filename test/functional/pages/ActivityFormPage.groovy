package page

import geb.Page

class ActivityFormPage extends Page {

    static url = "activity/create"

    static at = { driver.currentUrl.contains('activity/create') }

    static content = {
        activityForm { $('#activityForm') }
        submitButton { activityForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('#navbar').find('.logout') }
    }
}
