import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll

import page.LoginPage
import page.LogoutPage
import page.HomePage
import page.CompanyListPage

@Stepwise
class CompanyListAclSpec extends GebReportingSpec {

    def setupSpec() {

    }

    @Unroll
    def "Fill Form for Company"() {
        given:"A user login with authority #authority"
        to LoginPage
        loginForm.j_username = username
        loginForm.j_password = "12345678"
        loginButton.click()
        when: "navigate to Company list"
        to CompanyListPage
        then: "I should see the list"
        listContainer.present == result

        where: "We have the next cases"
        username            || result
        'admin'             || true
        'buyer'             || true
        'companyAdmin'      || true
        'companyViewer'     || true
        'cien'              || true
        'facilitator'       || false
        'musicicanAdmin'    || false
        'musicianViewer'    || false

    }

    def cleanup() {
        to LogoutPage
    }
}
