package page

import geb.Page

class SocialShowPage extends Page {

    static url = 'social/show'

    static at = { driver.currentUrl.contains('social/show') }

    static content = {
        backToMusician { $('a[href*="musician/show"]') }
        logout { $('#navbar').find('.logout') }
        
        alertSuccess (required: false) { $('.alert-info') }
        alertErrors (required: false) { $('.alert-danger') }
    }

}
