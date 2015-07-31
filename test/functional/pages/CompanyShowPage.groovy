package page

import geb.Page

class CompanyShowPage extends Page {

    static url = { driver.currentUrl.contains('company/show') }

    static at = { driver.currentUrl.contains('company/show') }

    static content = {
		alertSuccess (required:false) { $('.alert-info') }
		alertErrors (required:false) { $('.alert-danger') }

		companyListBtn { $('ul.nav-pills a.list') }

        editButtton { audioForm.find('.edit') }
        cancelButton { $("#btnCancel") }
    	logout       { $('#navbar').find('.logout') }

        createDatosFiscales { $('a[href*="datosFiscales/create"]') }
        createAddress { $('a[href*="address/create"]') }
        createSocial { $('a[href*="social/create"]') }
        createReference { $('a[href*="reference/create"]') }
        createCollaborator { $('a[href*="collaborator/create"]') }
        createEvent { $('a[href*="event/create"]') }
        createProduct { $('a[href*="product/create"]') }
    }
}
