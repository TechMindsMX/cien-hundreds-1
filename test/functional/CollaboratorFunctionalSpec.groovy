import geb.spock.GebReportingSpec

import spock.lang.Stepwise
import spock.lang.Unroll
import page.CollaboratorPage
import page.LoginPage

@Stepwise
class CollaboratorFunctionalSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = "12345678"
        loginButton.click()
    }

    @Unroll
    def "Fill Activity form"() {
        given:"form Buyer create"
        to CollaboratorPage

        when: "I do not fill form fields "
        collaboratorForm.firstName  = firstName
        collaboratorForm.motherLastName = motherLastName
        collaboratorForm.lastName   = lastName
        collaboratorForm.position   = position
        collaboratorForm.notes      = notes
        submitButton.click()

        then: "I am being redirected to the same page with errors"


        where: "We have the next cases"
        firstName   | motherLastName   | lastName   | position   | notes  || result
        'firstname' | 'middlename' | 'lastname' | 'position' | 'test' || CollaboratorPage
        'firstname' | 'middlename' | 'lastname' | 'position' | ''     || CollaboratorPage
        'firstname' | 'middlename' | 'lastname' | ''         | ''     || CollaboratorPage
        'firstname' | ''           | ''         | ''         | ''     || CollaboratorPage
        ''          | ''           | ''         | ''         | ''     || CollaboratorPage
    }

    def cleanupSpec() {}
}
