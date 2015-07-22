package page

import geb.Page

class CompanyCreatePage extends Page {

    static url = "company/create"

    static at = { driver.currentUrl.contains('company/create') }

    static content = {
        companyForm { $('.form-horizontal') }
        submitButton { $('#create') }
        cancelButton { $('form').find('button.btn') }
        logout { $('#navbar').find('.logout') }
    }
}
