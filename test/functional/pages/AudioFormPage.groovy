package page

import geb.Page

class AudioFormPage extends Page {

    static url = { driver.currentUrl.contains('audio/create') }

    static at = { driver.currentUrl.contains('audio/create') }

    static content = {
        audioForm    { $('#audioForm') }
        submitButton { audioForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('#navbar').find('.logout') }
    }
}
