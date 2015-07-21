import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import spock.lang.Shared

import page.CollaboratorEmailPage
import page.LoginPage

import spock.lang.Ignore
@Ignore
@Stepwise
class CollaboratorEmailFunctionalSpec extends GebReportingSpec {

    @Shared
    def grailsApplication = new org.codehaus.groovy.grails.commons.DefaultGrailsApplication()

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = grailsApplication.config.tests.userPassword
        loginButton.click()
    }

    @Unroll
    def "Fill Activity form"() {
        given:"form Buyer create"
        to CollaboratorEmailPage

        when: "I do not fill form fields "
        collaboratorEmailForm.address = address
        collaboratorEmailForm.type    = type

        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
         address                        | type       || result
         ''                             | 'PERSONAL' || CollaboratorEmailPage
         'luis.magana@techminds.com.mx' | 'WORK'     || CollaboratorEmailPage
         'lutek.valhalla@gmail.com'     | 'PERSONAL' || CollaboratorEmailPage
    }

    def cleanupSpec() {}
}
