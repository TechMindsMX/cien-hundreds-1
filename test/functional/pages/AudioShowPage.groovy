package page
import geb.Page

class AudioShowPage extends Page{

    static url = "audio/show"

    static at = { driver.currentUrl.contains('audio/show') }

    static content = {
		alertSuccess (required:false) { $('.alert-info') }
		alertErrors (required:false) { $('.alert-danger') }

        backToMusician { $('a[href*="musician/show"]') }

        editButtton { audioForm.find('.edit') }
        cancelButton { $("#btnCancel") }
        logout       { $('#navbar').find('.logout') }
    }
}


