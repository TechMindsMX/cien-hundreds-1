package page

import geb.Page

class GenrePage extends Page {

    static url = "genre/create"

    static at = { driver.currentUrl.contains('genre/create') }

    static content = {
        genreForm    { $('#genreForm') }
        submitButton { genreForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('.nav-header').find('.logout') }
    }
}
