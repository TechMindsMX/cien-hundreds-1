package page

import geb.Page

class GenrePage extends Page {

    static url = "genre/create"

    static at = { title == "100Hundreds" }

    static content = {
        genreForm    { $('#genreForm') }
        submitButton { genreForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('.nav-header').find('.logout') }
    }
}
