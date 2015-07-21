package page

import geb.Page

class GenreShowPage extends Page {

    static url = "genre/show"

    static at = { driver.currentUrl.contains('genre/show') }

    static content = {
        spanDato { $('.property-value') }
    }
}
