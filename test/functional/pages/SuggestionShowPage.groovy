package page

import geb.Page

class SuggestionShowPage extends Page {

    static url = { driver.currentUrl.contains('suggestion/show') }

    static at = { driver.currentUrl.contains('suggestion/show') }

    static content = {
        backToMusician { $('a[href*="musician/show"]') }
        logout { $('#navbar').find('.logout') }
        
        alertSuccess (required: false) { $('.alert-info') }
        alertErrors (required: false) { $('.alert-danger') }
    }

}
