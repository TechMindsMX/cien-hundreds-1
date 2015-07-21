package page

import geb.Page

class CollaboratorPage extends Page {

    static url = "collaborator/create"

    static at = { driver.currentUrl.contains('collaborator/create') }

    static content = {
        collaboratorForm { $('#collaboratorForm') }
        submitButton     { collaboratorForm.find('.save') }
        cancelButton     { $("#btnCancel") }
        logout           { $('#navbar').find('.logout') }
    }
}
