import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import spock.lang.Shared

import page.ActivityFormPage
import page.LoginPage

import spock.lang.Ignore
@Ignore
@Stepwise
class ActivityFunctionalSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = grailsApplication.config.tests.userPassword
        loginButton.click()
    }

    @Unroll
    def "Fill Activity form"() {
        given:"form Activity create"
        to ActivityFormPage

        when: "I don't fill form fields "
        activityForm.activity = activity
        activityForm.place    = place

        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
        activity          | place    || result
          ''              |  ''      || ActivityFormPage
          'no hacer nada' |  ''      || ActivityFormPage
          'no hacer nada' |  'algo'  || ActivityFormPage
    }

    def cleanupSpec() {}
}
