package page

import geb.Page

class SocialCreatePage extends Page {

    static url = 'social/create'

    static at = { driver.currentUrl.contains('social/create') }

    static content = {
        socialForm { $('form.form-horizontal') }
        submitButton { $('#create') }
        cancelButton { musicianForm.find(".btn-danger") }
        logout { $('.nav-header').find('.logout') }
    }

}
