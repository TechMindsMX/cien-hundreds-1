import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import spock.lang.Shared

import page.LoginPage
import page.LogoutPage
import page.HomePage
import page.CompanyCreatePage
import page.CompanyShowFirstPage

import spock.lang.Ignore
@Ignore
@Stepwise
class CompanyAclShowFirstFunctionalSpec extends GebReportingSpec {

    @Shared
    def grailsApplication = new org.codehaus.groovy.grails.commons.DefaultGrailsApplication()

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = grailsApplication.config.tests.userPassword
        loginButton.click()
        to CompanyCreatePage
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
        loginForm.j_password = grailsApplication.config.tests.userPassword
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
