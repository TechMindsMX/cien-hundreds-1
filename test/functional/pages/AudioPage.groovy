package page

import geb.Page

class AudioPage extends Page {

    static url = "audio/create"

    static at = { title == "100Hundreds" }

    static content = {
        audioForm    { $('#audioForm') }
        submitButton { audioForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('.nav-header').find('.logout') }
    }
}
