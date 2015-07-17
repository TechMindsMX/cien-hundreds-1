package page
import geb.Page

class PhotoFormPage extends Page{

    static url = "photo/create"

    static at = { driver.currentUrl.contains('photo/create') }

    static content = {
        photoForm 		{ $('#photoForm') }
        submitButton 	{ photoForm.find('.save') }
        cancelButton 	{ $("#btnCancel") }
        logout       	{ $('#navbar').find('.logout') }
    }
}


