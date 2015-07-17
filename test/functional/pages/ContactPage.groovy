package page

import geb.Page

class ContactPage extends Page {

    static url = "contact/create"

    static at = { driver.currentUrl.contains('contact/create') }

    static content = {
        contactForm { $('#contactForm') }
        submitButton { contactForm.find('.save') }
        cancelButton { $("#btnCancel") }
        roleSelect   { $('#role') }
        logout       { $('#navbar').find('.logout') }
    }
}
