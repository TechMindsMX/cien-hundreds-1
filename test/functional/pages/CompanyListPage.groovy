package page

import geb.Page

class CompanyListPage extends Page {

    static url = "company/index"

    static at = { title == "100Hundreds" }

    static content = {
    	listContainer ( required: false ) { $('#list-company') }
    }
}
