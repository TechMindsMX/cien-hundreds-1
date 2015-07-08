import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import page.VideoPage
import page.LoginPage

@Stepwise
class VideoFunctionalSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = "12345678"
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