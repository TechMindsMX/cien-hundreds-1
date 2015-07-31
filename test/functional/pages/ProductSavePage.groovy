package page

import geb.Page

class ProductSavePage extends Page {

    static url = { driver.currentUrl.contains('product/save') }

    static at = { driver.currentUrl.contains('product/save') }

    static content = {
        form    { $('#create-product form') }

		alertErrors (required:false) { $('.alert-danger') }

        submitButton { form.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('#navbar').find('.logout') }
    }
}
