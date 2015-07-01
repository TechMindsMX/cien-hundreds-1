package page
import geb.Page

/**
 * Created by dev-ismael on 01/07/2015.
 */

class VideoPage extends Page{
    static url = "video/create"
    static at = { title == "100Hundreds" }

    static content = {
        videoForm { $('#videoForm') }
        submitButton { videoForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('.nav-header').find('.logout') }
    }
}


