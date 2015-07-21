import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import spock.lang.Shared

import page.CollaboratorTelephonePage
import page.LoginPage

import spock.lang.Ignore
@Ignore
@Stepwise
class CollaboratorTelephoneFunctionalSpec extends GebReportingSpec {

    @Shared
    def grailsApplication = new org.codehaus.groovy.grails.commons.DefaultGrailsApplication()

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = grailsApplication.config.tests.userPassword
        loginButton.click()
    }

    @Unroll
    def "Fill Collaborator Telephone form"() {
        given:"form Collaborator Telephone create"
        to CollaboratorTelephonePage

        when: "I fill the form fields "
        collaboratorPhoneForm.phone = phone
        collaboratorPhoneForm.type  = type

        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
         phone        | type              || result
        '5522684789' | 'PERSONAL_MOBILE'  || CollaboratorTelephonePage
        '1234'       | 'WORK_MOBILE'      || CollaboratorTelephonePage
        ''           | 'PERSONAL'         || CollaboratorTelephonePage
    }

    def cleanupSpec() {}
}
