package page
import geb.Page

class PrepareTelephoneFormPage extends Page {

    static url = "prepareTelephone"

    static at = { driver.currentUrl.contains('prepareTelephone') }

    static content = {
        userTelephoneForm { $('.telephone-form') }
        submitButton { userTelephoneForm.find('.save') }
        cancelButton { $("#btnCancel") }
        uuid         { $("#uuid") }
        type         { $("#type")}
        logout       { $('#navbar').find('.logout') }
    }

}
