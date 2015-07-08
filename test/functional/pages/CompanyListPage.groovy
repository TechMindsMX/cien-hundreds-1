package page

import geb.Page

class CompanyListPage extends Page {

    static url = "company/index"

    static at = { driver.currentUrl.contains('company/index') }

    static content = {
    	listContainer ( required: false ) { $('#list-company') }
    }
}
