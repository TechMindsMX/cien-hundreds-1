package page

import geb.Page

class CompanyShowFirstPage extends Page {

    static url = "company/show/1"

    static at = { driver.currentUrl.contains('company/show/1') }

    static content = {
    	logout       { $('#navbar').find('.logout') }
    }
}
