package page
import geb.Page

class VideoPage extends Page{

    static url = "video/create"

    static at = { driver.currentUrl.contains('video/create') }

    static content = {
        videoForm { $('#videoForm') }
        submitButton { videoForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('.nav-header').find('.logout') }
    }
}


