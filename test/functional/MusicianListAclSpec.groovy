import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll

import page.LoginPage
import page.LogoutPage
import page.HomePage
import page.MusicianListPage

@Stepwise
class MusicianListAclSpec extends GebReportingSpec {

    def setup() {
        to LoginPage
    }

    @Unroll
    void """When we authenticate with the username #username, we expect to be able to access the Musician list"""() {
        given:"A user login with authority #authority"
        loginForm.j_username = username
        loginForm.j_password = "12345678"
        loginButton.click()
        when: "navigate to Musician list"
        to MusicianListPage
        then: "I should see the list"
        listContainer.present == result

        where: "We have the next cases"
        username            || result
        'admin'             || true
        'musicicanAdmin'    || true
        'facilitator'       || true
        'musicianViewer'    || true
        'cien'              || true
        'buyer'             || false
        'companyAdmin'      || false
        'companyViewer'     || false
    }

    def cleanup() {
        to LogoutPage
    }
}
