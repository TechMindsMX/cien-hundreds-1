import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import page.LoginPage
import page.HomePage
import page.CompanyListPage

@Stepwise
class CompanyAclSpec extends GebReportingSpec {

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
        then: "I am being redirected to the same page with errors"
        at CompanyListPage

        where: "We have the next cases"
        username            || result
        'admin'             || true
        // 'buyer'             || true
        // 'companyAdmin'      || true
        // 'companyViewer'     || true
        // 'cien'              || false
        // 'facilitator'       || false
        // 'musicicanAdmin'    || false
        // 'musicianViewer'    || false

    }

    def cleanupSpec() {
        logout.click()
        to HomePage
    }
}
