package page

import geb.Page

class FacilitatorPage extends Page {

    static url = "admin/create"

    static at = { driver.currentUrl.contains('admin/create') }

    static content = {
        facilitatorForm { $('.form-horizontal') }
        submitButton { $('#create') }
        cancelButton { facilitatorForm.find(".btn-danger") }
        logout { $('#navbar').find('.logout') }
    }
}
