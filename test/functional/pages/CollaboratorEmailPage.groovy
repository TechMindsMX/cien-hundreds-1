package page

import geb.Page

class CollaboratorEmailPage extends Page {

    static url = "collaboratorEmail/create?collaborator.id=1"

    static at = { title == "100Hundreds" }

    static content = {
        collaboratorEmailForm { $('#collaboratorEmailForm') }
        submitButton          { collaboratorEmailForm.find('.save') }
        cancelButton          { $("#btnCancel") }
        logout                { $('.nav-header').find('.logout') }
    }
}
