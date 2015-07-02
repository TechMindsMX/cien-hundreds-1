package page

import geb.Page

class MusicianListPage extends Page {

    static url = "musician/index"

    static at = { title == "100Hundreds" }

    static content = {
    	listContainer (required: false) {$('#list-musician')}
    }
}
