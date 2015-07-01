package page

import geb.Page

class CompanyListPage extends Page {

    static url = "company/index"

    static at = { title == "100Hundreds" }

    static content = {
    	logout       { $('.nav-header').find('.logout') }
    }
}
