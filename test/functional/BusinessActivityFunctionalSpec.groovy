import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import spock.lang.Shared

import page.BusinessActivityPage
import page.LoginPage

@Stepwise
class BusinessActivityFunctionalSpec extends GebReportingSpec {

    @Shared
    def grailsApplication = new org.codehaus.groovy.grails.commons.DefaultGrailsApplication()

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = grailsApplication.config.tests.userPassword
        loginButton.click()
    }

    @Unroll
    def "Fill Business Activity form"() {
        given:"form business activity create"
        to BusinessActivityPage

        when: "I do not fill form fields "
        businessActivityForm.name = name

        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
        name   || result
        ''     || BusinessActivityPage
        'test' || BusinessActivityPage
    }

    def cleanupSpec() {}
}
