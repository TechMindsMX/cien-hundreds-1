package page

import geb.Page

class MusicianShowPage extends Page {

	static url = { driver.currentUrl.contains('musician/show') }

	static at = { driver.currentUrl.contains('musician/show') }

	static content = {
		success (required:false) { $('.alert-info') }
		errors (required:false) { $('.alert-danger') }
	}
}