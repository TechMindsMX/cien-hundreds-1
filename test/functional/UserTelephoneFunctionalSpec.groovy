import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import page.UserTelephonePage
import page.LoginPage

@Stepwise
class UserTelephoneFunctionalSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = "12345678"
        loginButton.click()
    }

    @Unroll
    def "Fill UserTelephonePage form"() {
        given:"form UserTelephonePage create"
        to UserTelephonePage

        when: "I don't fill the form fields "
        userTelephoneForm.phone     = phone
        type                        = type
        user                      = userId
        userTelephoneForm.uuid      = uuid


        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
        phone        | type          | userId            | uuid                               || result
        ''           | ''            | '1'               | ''                                 || UserTelephonePage
        '1234567890' | ''            | '1'               | ''                                 || UserTelephonePage
        '12345678'   | ''            | '1'               | ''                                 || UserTelephonePage
        '12345678901'| ''            | '1'               | ''                                 || UserTelephonePage
        '1234567890' | 'WORK'        | '1'               | ''                                 || UserTelephonePage
        '1234567890' | 'WORK'        | '1'               | ''                                 || UserTelephonePage
        '1234567890' | 'WORK'        | '1'               | ''                                 || UserTelephonePage
        '1234567890' | 'WORK'        | '1'               | ''                                 || UserTelephonePage
        '1234567890' | 'WORK'        | '1'               | '7d0f82f'                          || UserTelephonePage
        '1234567890' | 'WORK'        | '1'               | '7d0f82fbb0ba4beabda87d25914590c9' || UserTelephonePage
    }

    def cleanupSpec() {}
}
