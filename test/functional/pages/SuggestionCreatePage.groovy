package page

import geb.Page

class SuggestionCreatePage extends Page {

    static url = { driver.currentUrl.contains('suggestion/create') }

    static at = { driver.currentUrl.contains('suggestion/create') }

    static content = {
        suggestionForm { $('#suggestionForm') }
        submitButton { suggestionForm.find('.save') }
        cancelButton { $("#btnCancel") }
        
        alertSuccess (required: false) { $('.alert-info') }
        alertErrors (required: false) { $('.alert-danger') }
    }

}
