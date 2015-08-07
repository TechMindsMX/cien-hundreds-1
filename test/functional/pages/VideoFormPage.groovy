package page
import geb.Page

class VideoFormPage extends Page{

    static url = { driver.currentUrl.contains('video/create') }

    static at = { driver.currentUrl.contains('video/create') }

    static content = {
        videoForm { $('#videoForm') }
        submitButton { videoForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('#navbar').find('.logout') }
    }
}
