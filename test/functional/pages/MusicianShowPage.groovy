package page

import geb.Page

class MusicianShowPage extends Page {

	static url = { driver.currentUrl.contains('musician/show') }

	static at = { driver.currentUrl.contains('musician/show') }

	static content = {
		success (required:false) { $('.alert-info') }
		errors (required:false) { $('.alert-danger') }

        contactCreate { $('a[href*="contact/create"]') }
        socialCreate { $('a[href*="social/create"]') }
        activityCreate { $('a[href*="activity/create"]') }
        videoCreate { $('a[href*="video/create"]') }
        audio { $('a[href*="audio/create"]') }
        photoCreate { $('a[href*="photo/create"]') }
        suggestionCreate { $('a[href*="suggestion/create"]') }
        datosFiscalesCreate { $('a[href*="datosFiscales/create"]') }
	}
}