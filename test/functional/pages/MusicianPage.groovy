package page

import geb.Page

class MusicianPage extends Page {

    static url = "musician/create"

    static at = { title ==~ "Mostrar" }

    static content = {
        musicianForm { $('form.form-horizontal') }
        submitButton { $('#create') }
        cancelButton { musicianForm.find(".btn-danger") }
        select       { $('#genre') }
        logout { $('.nav-header').find('.logout') }
    }
}
