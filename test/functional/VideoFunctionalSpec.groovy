import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import spock.lang.Shared
import page.VideoPage
import page.LoginPage

import spock.lang.Ignore
@Ignore
@Stepwise
class VideoFunctionalSpec extends GebReportingSpec {

    @Shared
    def grailsApplication = new org.codehaus.groovy.grails.commons.DefaultGrailsApplication()

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = grailsApplication.config.tests.userPassword
        loginButton.click()
    }

    @Unroll
    def "Fill Video form"() {
        given:"form Video create"
        to VideoPage

        when: "I don't fill the form fields "
        videoForm.url = siteUrl


        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
        siteUrl                                       || result
        ''                                            || VideoPage
        'No video'                                    || VideoPage
        'https://www.youtube.com/watch?v=wP1zAyibHm8' || VideoPage
    }

    def cleanupSpec() {
    }
}
