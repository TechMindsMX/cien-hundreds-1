import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import spock.lang.Shared

import page.LoginPage
import page.FacilitatorPage

@Stepwise
class FacilitatorFunctionalSpec extends GebReportingSpec {

    @Shared
    def grailsApplication = new org.codehaus.groovy.grails.commons.DefaultGrailsApplication()

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = grailsApplication.config.tests.userPassword
        loginButton.click()
    }

    @Unroll
    def "Fill Form for Facilitator"() {
        given:"Create Facilitator Form"
        to FacilitatorPage
        when: "I do fill fields form with"
        facilitatorForm.username      = username
        facilitatorForm.password      = password
        facilitatorForm.passwordCheck = passwordCheck
        facilitatorForm.firstName     = firstName
        facilitatorForm.motherLastName    = motherLastName
        facilitatorForm.lastName      = lastName
        facilitatorForm.phone         = phone
        facilitatorForm.email         = email
        facilitatorForm.emailCheck    = emailCheck

        then: "I am being redirected to the same page with errors"
        submitButton.click()
        where: "We have the next cases"
        username | password | passwordCheck | firstName | motherLastName    | lastName | phone | email | emailCheck || result
        ''       | ''       | ''            | ''        | ''                | ''       | ''    |  ''   | ''         || FacilitatorPage
        'Luis'   | ''       | ''            | ''        | ''                | ''       | ''    |  ''   | ''         || FacilitatorPage

    }

    def cleanupSpec() {}
}
