import geb.spock.GebReportingSpec

import spock.lang.Stepwise
import spock.lang.Unroll
import page.BusinessActivityPage
import page.LoginPage

@Stepwise
class BusinessActivitySpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = "12345678"
        loginButton.click()
    }

    @Unroll
    def "Fill Business Activity form"() {
        given:"form business activity create"
        to BusinessActivityPage

        when: "I do not fill form fields "
        businessActivityForm.name = name

        then: "I am being redirected to the same page whit errors"
        submitButton.click()

        where: "We have the next cases"
        name   || result
        ''     || BusinessActivityPage
        'test' || BusinessActivityPage
    }

    def cleanupSpec() {}
}
