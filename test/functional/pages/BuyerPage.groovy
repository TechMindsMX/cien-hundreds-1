package page

import geb.Page

class BuyerPage extends Page {

    static url = "buyer/create"

    static at = { title == "100Hundreds" }

    static content = {
        buyerForm { $('#aqui') }
        submitButton { buyerForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout { $('.nav-header').find('.logout') }
    }
}
