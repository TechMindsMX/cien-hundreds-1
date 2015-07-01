package page

import geb.Page
import org.openqa.selenium.JavascriptExecutor

class AddressPage extends Page {


    def js( String script ){
        (driver as JavascriptExecutor).executeScript( script )
    }

    static url = "address/create"

    static at = { title == "100Hundreds" }

    static content = {
        addressForm  { $('#addressForm') }
        submitButton { addressForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout       { $('.nav-header').find('.logout') }
    }
}
