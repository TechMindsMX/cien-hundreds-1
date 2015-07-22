package page

import geb.Page

class CompanyShowPage extends Page {

    static url = { driver.currentUrl.contains('company/show') }

    static at = { driver.currentUrl.contains('company/show') }

    static content = {
    	logout       { $('#navbar').find('.logout') }
    }
}
