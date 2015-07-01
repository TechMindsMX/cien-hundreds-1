package page

import geb.Page

class FacilitatorPage extends Page {

    static url = "facilitator/create"

    static at = { title == "100Hundreds" }

    static content = {
        facilitatorForm { $('form.form-horizontal') }
        submitButton { $('#create') }
        cancelButton { facilitatorForm.find(".btn-danger") }
        logout { $('.nav-header').find('.logout') }
    }
}
