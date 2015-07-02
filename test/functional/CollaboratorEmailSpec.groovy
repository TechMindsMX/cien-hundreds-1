import geb.spock.GebReportingSpec

import spock.lang.Stepwise
import spock.lang.Unroll
import page.CollaboratorEmailPage
import page.LoginPage

@Stepwise
class CollaboratorEmailSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = "12345678"
        loginButton.click()
    }

    @Unroll
    def "Fill Activity form"() {
        given:"form Buyer create"
        to CollaboratorEmailPage

        when: "I do not fill form fields "
        collaboratorEmailForm.address = address
        collaboratorEmailForm.type    = type

        then: "I am being redirected to the same page whit errors"
        submitButton.click()

        where: "We have the next cases"
         address                        | type       || result
         ''                             | 'PERSONAL' || CollaboratorEmailPage
         'luis.magana@techminds.com.mx' | 'WORK'     || CollaboratorEmailPage
         'lutek.valhalla@gmail.com'     | 'PERSONAL' || CollaboratorEmailPage
    }

    def cleanupSpec() {}
}
