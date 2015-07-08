import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import page.UserEmailPage
import page.LoginPage

@Stepwise
class UserEmailFunctionalSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = "12345678"
        loginButton.click()
    }

    @Unroll
    def "Fill UserEmailPage form"() {
        given:"form UserEmailPage create"
        to UserEmailPage

        when: "I don't fill the form fields "
        userEmailForm.address     = address
        type                      = typeAddress
        user                      = userId
        userEmailForm.uuid        = uuid


        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
        address        | typeAddress   | userId            | uuid                               || result
        ''             | 'WORK'        | '1'               | '7d0f82fbb0ba4beabda87d25914590c9' || UserEmailPage
        '1234567890'   | ''            | '1'               | '7d0f82fbb0ba4beabda87d25914590c9' || UserEmailPage
        '12345678'     | 'WORK'        | ''                | '7d0f82fbb0ba4beabda87d25914590c9' || UserEmailPage
        '12345678901'  | 'WORK'        | '1'               | ''                                 || UserEmailPage
        '1234567890'   | 'WORK'        | '1'               | '7d0f82fbb0ba4beabda87d25914590c9' || UserEmailPage
    }

    def cleanupSpec() {}
}
