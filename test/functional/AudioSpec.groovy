import geb.spock.GebReportingSpec

import spock.lang.Stepwise
import spock.lang.Unroll
import page.AudioPage
import page.LoginPage

@Stepwise
class AudioSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = "12345678"
        loginButton.click()
    }

    @Unroll
    def "Fill Audio form"() {
        given:"form Audio create"
        to AudioPage

        when: "I fill the Audio form"
        audioForm.url = url

        then: "I am being redirected to the same page whit errors or redirect to view Audio page."
        submitButton.click()

        where: "We have the next cases"
        url                                                                  || result
        ''                                                                   || AudioPage //Error
        'https://www.youtube.com/watch?v=RgKAFK5djSk'                        || AudioPage //Error
        'https://soundcloud.com/metalbladerecords/act-of-defiance-throwback' || AudioPage //Pass
    }

    def cleanupSpec() {}
}
