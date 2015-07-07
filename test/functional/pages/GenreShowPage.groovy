package page

import geb.Page

class GenreShowPage extends Page {

    static url = "activity/create"

    static at = { driver.currentUrl.contains('activity/create') }

    static content = {
        spanDato { $('.property-value') }
    }
}
