import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import page.AddressPage
import page.LoginPage

@Stepwise
class AddressSpec extends GebReportingSpec {
    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = "12345678"
        loginButton.click()
    }

    @Unroll
    def "Fill Address form"() {
        given:"form Address create"
        to AddressPage

        when: "I fill the form fields"
        addressForm.country      = country
        addressForm.street       = street
        addressForm.zipcode      = zipcode

        js('jQuery("#zipcode").trigger("change")')

        addressForm.neighborhood = neighborhood
        addressForm.county       = county
        addressForm.town         = town
        addressForm.state        = state

        then: "I am being redirected to the same page with errors"
        submitButton.click()
        at AddressPage

        where: "We have the next cases"
        country | street            | zipcode | neighborhood  | county | town   | state     || result
        ''      | ''                | ''      | ''            | ''     | ''     | ''        || AddressPage
        'mex'   | 'San Itario #666' | '43904' | 'Azteca'      | 'Apan' | 'Apan' | 'Hidalgo' || AddressPage
    }

    def cleanupSpec() {}
}
