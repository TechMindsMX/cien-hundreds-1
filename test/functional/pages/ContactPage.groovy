package page

import geb.Page

class ContactPage extends Page {

    static url = "contact/create"

    static at = { title == "100Hundreds" }

    static content = {
        contactForm { $('#contactForm') }
        submitButton { contactForm.find('.save') }
        cancelButton { $("#btnCancel") }
        roleSelect   { $('#role') }
        logout       { $('.nav-header').find('.logout') }
    }
}
