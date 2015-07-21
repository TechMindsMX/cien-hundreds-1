package page

import geb.Page

class MusicianShowPage extends Page {

    static url = { driver.currentUrl.contains('musician/show') }

    static at = { driver.currentUrl.contains('musician/show') }

    static content = {
       success (required:false) { $('.alert-info') }
       errors (required:false) { $('.alert-danger') }

       addContact { $('a[href*="contact/create"]') }
       addSocial { $('a[href*="social/create"]') }
       addActivity { $('a[href*="activity/create"]') }
       addVideo { $('a[href*="video/create"]') }
       addAudio { $('a[href*="audio/create"]') }
       addPhoto { $('a[href*="photo/create"]') }
       addSuggestion { $('a[href*="suggestion/create"]') }
       addDatosFiscales { $('a[href*="datosFiscales/create"]') }
   }
}