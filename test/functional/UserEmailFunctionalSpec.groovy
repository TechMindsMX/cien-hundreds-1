import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import spock.lang.Shared
import page.PrepareEmailFormPage
import page.LoginPage

import spock.lang.Ignore
@Ignore
@Stepwise
class UserEmailFunctionalSpec extends GebReportingSpec {

    @Shared
    def grailsApplication = new org.codehaus.groovy.grails.commons.DefaultGrailsApplication()

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = grailsApplication.config.tests.userPassword
        loginButton.click()
    }

    @Unroll
    def "Fill PrepareEmailFormPage form"() {
        given:"form PrepareEmailFormPage create"
        to PrepareEmailFormPage

        when: "I don't fill the form fields "
        userEmailForm.address     = address
        type                      = typeAddress
        user                      = userId
        userEmailForm.uuid        = uuid


        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
        address        | typeAddress   | userId            | uuid                               || result
        ''             | 'WORK'        | '1'               | '7d0f82fbb0ba4beabda87d25914590c9' || PrepareEmailFormPage
        '1234567890'   | ''            | '1'               | '7d0f82fbb0ba4beabda87d25914590c9' || PrepareEmailFormPage
        '12345678'     | 'WORK'        | ''                | '7d0f82fbb0ba4beabda87d25914590c9' || PrepareEmailFormPage
        '12345678901'  | 'WORK'        | '1'               | ''                                 || PrepareEmailFormPage
        '1234567890'   | 'WORK'        | '1'               | '7d0f82fbb0ba4beabda87d25914590c9' || PrepareEmailFormPage
    }

    def cleanupSpec() {}
}
