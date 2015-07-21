package page

import geb.Page

class CollaboratorTelephonePage extends Page {

    static url = "collaboratorTelephone/create?collaborator.id=1"

    static at = { driver.currentUrl.contains('collaboratorTelephone/create?collaborator') }

    static content = {
        collaboratorPhoneForm { $('#collaboratorPhoneForm') }
        submitButton          { collaboratorPhoneForm.find('.save') }
        cancelButton          { $("#btnCancel") }
        logout                { $('#navbar').find('.logout') }
    }
}
