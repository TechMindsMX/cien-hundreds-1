package page

import geb.Page

class CompanyPage extends Page {

    static url = "company/create"

    static at = { driver.currentUrl.contains('company/create') }

    static content = {
        companyForm { $('form') }
        submitButton { $('#create') }
        cancelButton { $('form').find('button.btn') }
        logout { $('.nav-header').find('.logout') }

        companyName { $() }
    }
}
