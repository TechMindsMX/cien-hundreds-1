package page

import geb.Page

class GenreShowPage extends Page {

    static url = "activity/create"

    static at = { title == "100Hundreds" }

    static content = {
        spanDato { $('.property-value') }
    }
}
