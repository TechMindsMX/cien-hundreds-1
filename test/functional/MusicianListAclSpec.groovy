import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll

import page.LoginPage
import page.LogoutPage
import page.HomePage
import page.MusicianListPage

@Stepwise
class MusicianListAclSpec extends GebReportingSpec {

    def setupSpec() {

    }

    @Unroll
    def "Fill Form for Musician"() {
        given:"A user login with authority #authority"
        to LoginPage
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
        'cien'              || false
        'buyer'             || false
        'companyAdmin'      || false
        'companyViewer'     || false
    }

    def cleanup() {
        to LogoutPage
    }
}
