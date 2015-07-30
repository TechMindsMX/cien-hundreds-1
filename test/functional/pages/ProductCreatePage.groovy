package page

import geb.Page

class ProductCreatePage extends Page {

    static url = { driver.currentUrl.contains('product/create') }

    static at = { driver.currentUrl.contains('product/create') }

    static content = {
        form    { $('#create-product form') }

        submitButton { form.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('#navbar').find('.logout') }
    }
}
