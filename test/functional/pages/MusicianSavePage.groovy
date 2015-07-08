package page

import geb.Page

class MusicianSavePage extends Page {

	static url = { driver.currentUrl.contains('musician/save') }

	static at = { driver.currentUrl.contains('musician/save') }

	static content = {
		success (required:false) { $('.alert-info') }
		errors (required:false) { $('.alert-danger') }
	}
}