package page

import geb.Page

class CompanySavePage extends Page {

    static url = "company/save"

    static at = { driver.currentUrl.contains('company/save') }

    static content = {
        companyForm    { $('.form-horizontal') }
        submitButton { genreForm.find('.save') }
        cancelButton { $("#btnCancel") }

        alertErrors { $('.alert-danger') }

    }
}
