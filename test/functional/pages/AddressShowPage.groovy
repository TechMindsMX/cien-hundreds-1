package page

import geb.Page
import org.openqa.selenium.JavascriptExecutor

class AddressShowPage extends Page {

    def js( String script ){
        (driver as JavascriptExecutor).executeScript( script )
    }

    static url = "address/show"

    static at = { driver.currentUrl.contains('address/show') }

    static content = {
        editButton { addressForm.find('.edit') }
        cancelButton { $("#btnCancel") }

        backToMusician (required: false) { $('a[href*="musician/show"]') }
        company (required: false) { $('a[href*="company/show"]') }
        contact (required: false) { $('a[href*="contact/show"]') }
        datosFiscales (required: false) { $('a[href*="datosFiscales/show"]') }

        alertSuccess (required: false) { $('.alert-info') }
        alertErrors (required: false) { $('.alert-danger') }
    }
}
