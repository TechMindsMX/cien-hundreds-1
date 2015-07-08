import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll

import page.LoginPage
import page.LogoutPage
import page.HomePage
import page.CompanyPage
import page.CompanyShowFirstPage

@Stepwise
class CompanyAclShowFunctionalFirstSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = "12345678"
        loginButton.click()
        to CompanyPage
        companyForm.name = "company1"
        companyForm.description = "description1"
        submitButton.click()
        to LogoutPage
    }

    @Unroll
    def "Fill Form for Company"() {
        given:"A user login with authority #authority"
        to LoginPage
        loginForm.j_username = username
        loginForm.j_password = "12345678"
        loginButton.click()
        when: "navigate to Company show page for first company"
        to CompanyShowFirstPage
        then: "I see the datails of the company"
        at CompanyShowFirstPage

        where: "We have the next cases"
        username            || result
        'admin'             || true
        'buyer'             || true
        'companyAdmin'      || true
        'companyViewer'     || true
        'cien'              || true
        'facilitator'       || true
        'musicicanAdmin'    || true
        'musicianViewer'    || true

    }

    def cleanup() {
        to LogoutPage
    }
}
