package page

import geb.Page

class GenreSavePage extends Page {

    static url = "genre/save"

    static at = { driver.currentUrl.contains('genre/save') }

    static content = {
        genreForm    { $('#genreForm') }
        submitButton { genreForm.find('.save') }
        cancelButton { $("#btnCancel") }

        alertErrors { $('.alert-danger') }

    }
}
