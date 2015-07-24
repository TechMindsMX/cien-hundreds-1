package page

import geb.Page

class CompanyShowPage extends Page {

    static url = { driver.currentUrl.contains('company/show') }

    static at = { driver.currentUrl.contains('company/show') }

    static content = {
		alertSuccess (required:false) { $('.alert-info') }
		alertErrors (required:false) { $('.alert-danger') }

        editButtton { audioForm.find('.edit') }
        cancelButton { $("#btnCancel") }
    	logout       { $('#navbar').find('.logout') }
    }
}
