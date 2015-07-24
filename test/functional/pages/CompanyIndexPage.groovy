package page

import geb.Page

class CompanyIndexPage extends Page {

    static url = { driver.currentUrl.contains('company/index') }

    static at = { driver.currentUrl.contains('company/index') }

    static content = {
		alertSuccess (required:false) { $('.alert-info') }
		alertErrors (required:false) { $('.alert-danger') }

		list { $('#list-company') }

        editButtton { audioForm.find('.edit') }
        cancelButton { $("#btnCancel") }
    	logout       { $('#navbar').find('.logout') }
    }
}
