package page

import geb.Page
import org.openqa.selenium.JavascriptExecutor

class AddressSavePage extends Page {

    def js( String script ){
        (driver as JavascriptExecutor).executeScript( script )
    }

    static url = "address/create"

    static at = { driver.currentUrl.contains('address/save') }

    static content = {
        addressForm  { $('#addressForm') }
        submitButton { addressForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('.nav-header').find('.logout') }

        alertSuccess (required: false) { $('.alert-info') }
        alertErrors (required: false) { $('.alert-danger') }
    }
}
