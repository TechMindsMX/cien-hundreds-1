package page

import geb.Page
import org.openqa.selenium.JavascriptExecutor

class AddressFormPage extends Page {

    def js( String script ){
        (driver as JavascriptExecutor).executeScript( script )
    }

    static url = "address/create"

    static at = { driver.currentUrl.contains('address/create') }

    static content = {
        addressForm  { $('#addressForm') }
        submitButton { addressForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('.nav-header').find('.logout') }
    }
}
