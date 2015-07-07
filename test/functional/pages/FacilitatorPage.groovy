package page

import geb.Page

class FacilitatorPage extends Page {

    static url = "facilitator/create"

    static at = { driver.currentUrl.contains('facilitator/create') }

    static content = {
        facilitatorForm { $('form.form-horizontal') }
        submitButton { $('#create') }
        cancelButton { facilitatorForm.find(".btn-danger") }
        logout { $('.nav-header').find('.logout') }
    }
}
