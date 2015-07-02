package page

import geb.Page

class CollaboratorTelephonePage extends Page {

    static url = "collaboratorTelephone/create?collaborator.id=1"

    static at = { title == "100Hundreds" }

    static content = {
        collaboratorPhoneForm { $('#collaboratorPhoneForm') }
        submitButton          { collaboratorPhoneForm.find('.save') }
        cancelButton          { $("#btnCancel") }
        logout                { $('.nav-header').find('.logout') }
    }
}
