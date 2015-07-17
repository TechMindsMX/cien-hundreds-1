package page
import geb.Page

class VideoShowPage extends Page{

    static url = "video/show"

    static at = { driver.currentUrl.contains('video/show') }

    static content = {
        backToMusician { $('a[href*="musician/show"]') }

        editButtton { videoForm.find('.edit') }
        cancelButton { $("#btnCancel") }
        logout       { $('.nav-header').find('.logout') }
    }
}


