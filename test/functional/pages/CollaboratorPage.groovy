package page

import geb.Page

class CollaboratorPage extends Page {

    static url = "collaborator/create"

    static at = { title == "100Hundreds" }

    static content = {
        collaboratorForm { $('#collaboratorForm') }
        submitButton     { collaboratorForm.find('.save') }
        cancelButton     { $("#btnCancel") }
        logout           { $('.nav-header').find('.logout') }
    }
}
