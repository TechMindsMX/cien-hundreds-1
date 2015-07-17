package page
import geb.Page

class PrepareEmailFormPage extends Page {

    static url = "prepareEmail"

    static at = { driver.currentUrl.contains('prepareEmail') }

    static content = {
        emailForm       { $('.email-form') }
        submitButton    { emailForm.find('.save') }
        cancelButton    { $("#btnCancel") }
        user            { $("#user") }
        type            { $("#type")}
        logout          { $('.nav-header').find('.logout') }
    }

}
