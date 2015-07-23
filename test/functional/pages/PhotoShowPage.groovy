package page
import geb.Page

class PhotoShowPage extends Page{

    static url = "photo/show"

    static at = { driver.currentUrl.contains('photo/show') }

    static content = {
		alertSuccess (required:false) { $('.alert-info') }
		alertErrors (required:false) { $('.alert-danger') }

        backToMusician { $('a[href*="musician/show"]') }

        editButtton { photoForm.find('.edit') }
        cancelButton { $("#btnCancel") }
        logout       { $('#navbar').find('.logout') }
    }
}


