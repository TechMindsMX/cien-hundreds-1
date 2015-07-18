import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import spock.lang.Shared

import page.AudioFormPage
import page.LoginPage

import spock.lang.Ignore
@Ignore
@Stepwise
class AudioFunctionalSpec extends GebReportingSpec {

    @Shared
    def grailsApplication = new org.codehaus.groovy.grails.commons.DefaultGrailsApplication()

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = grailsApplication.config.tests.userPassword
        loginButton.click()
    }

    @Unroll
    def "Fill Audio form"() {
        given:"form Audio create"
        to AudioFormPage

        when: "I fill the Audio form"
        audioForm.url = url

        then: "I am being redirected to the same page with errors or redirect to view Audio page."
        submitButton.click()

        where: "We have the next cases"
        url                                                                  || result
        ''                                                                   || AudioFormPage //Error
        'https://www.youtube.com/watch?v=RgKAFK5djSk'                        || AudioFormPage //Error
        'https://soundcloud.com/metalbladerecords/act-of-defiance-throwback' || AudioFormPage //Pass
    }

    def cleanupSpec() {}
}
