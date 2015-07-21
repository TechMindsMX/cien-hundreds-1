package page

import geb.Page

class GenreCreatePage extends Page {

    static url = "genre/create"

    static at = { driver.currentUrl.contains('genre/create') }

    static content = {
        genreForm    { $('#genreForm') }
        submitButton { genreForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('#navbar').find('.logout') }
    }
}
