package page

import geb.Page

class MusicianListPage extends Page {

    static url = 'musician/index'

    static at = { driver.currentUrl.endsWith('musician/index') }

    static content = {
    	listContainer (required: false) {$('#list-musician')}
    }

}
