package page

import geb.Page

class CollaboratorEmailPage extends Page {

    static url = "collaboratorEmail/create?collaborator.id=1"

    static at = { driver.currentUrl.contains('collaboratorEmail/create') }

    static content = {
        collaboratorEmailForm { $('#collaboratorEmailForm') }
        submitButton          { collaboratorEmailForm.find('.save') }
        cancelButton          { $("#btnCancel") }
        logout                { $('#navbar').find('.logout') }
    }
}
