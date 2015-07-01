package page

import geb.Page

class BuyerSavePage extends Page {

    static url = "buyer/save"

    static at = { title == "100Hundreds" }

    static content = {
        buyerForm { $('#aqui') }
        submitButton { buyerForm.find('.save') }
        cancelButton { $("#btnCancel") }
        logout { $('.nav-header').find('.logout') }
    }
}
