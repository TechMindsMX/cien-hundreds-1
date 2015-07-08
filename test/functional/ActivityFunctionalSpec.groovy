import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import page.ActivityPage
import page.LoginPage

@Stepwise
class ActivityFunctionalSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = "12345678"
        loginButton.click()
    }

    @Unroll
    def "Fill Activity form"() {
        given:"form Activity create"
        to ActivityPage

        when: "I don't fill form fields "
        activityForm.activity = activity
        activityForm.place    = place

        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
        activity          | place    || result
          ''              |  ''      || ActivityPage
          'no hacer nada' |  ''      || ActivityPage
          'no hacer nada' |  'algo'  || ActivityPage
    }

    def cleanupSpec() {}
}
