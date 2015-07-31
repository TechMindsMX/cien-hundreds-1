package page

import geb.Page

class ProductShowPage extends Page {

    static url = { driver.currentUrl.contains('product/show') }

    static at = { driver.currentUrl.contains('product/show') }

    static content = {
       alertSuccess (required:false) { $('.alert-info') }
       alertErrors (required:false) { $('.alert-danger') }

       addComplement { $('a[href*="complement/create"]') }
       backToCompany { $('a[href*="company/show"]') }
   }
}