package page
import geb.Page

class VideoShowPage extends Page{

    static url = "video/show"

    static at = { driver.currentUrl.contains('video/show') }

    static content = {
		alertSuccess (required:false) { $('.alert-info') }
		alertErrors (required:false) { $('.alert-danger') }

        backToMusician { $('a[href*="musician/show"]') }

        editButtton { videoForm.find('.edit') }
        cancelButton { $("#btnCancel") }
        logout       { $('#navbar').find('.logout') }
    }
}


