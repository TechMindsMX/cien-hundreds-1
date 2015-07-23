package page

import geb.Page

class ContactShowPage extends Page {

    static url = "contact/show"

    static at = { driver.currentUrl.contains('contact/show') }

    static content = {
        alertSuccess (required:false) { $('.alert-info') }
        alertErrors (required:false) { $('.alert-danger') }

        cancelButton 	{ $("#btnCancel") }
        backToMusician 	{ $('a[href*="musician/show"]') }
        logout       	{ $('#navbar').find('.logout') }

        addTelephone 	{ $('a[href*="prepareTelephone"]') } 
        addEmail 		{ $('a[href*="prepareEmail"]') } 
        addSocial 		{ $('a[href*="social/create"]') } 
        addAddress 		{ $('a[href*="address/create"]') } 
    }
}
