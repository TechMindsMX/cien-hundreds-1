package page

import geb.Page

class CompanyShowFirstPage extends Page {

    static url = "company/show/1"

    static at = { title == "100Hundreds" }

    static content = {
    	logout       { $('.nav-header').find('.logout') }
    }
}
