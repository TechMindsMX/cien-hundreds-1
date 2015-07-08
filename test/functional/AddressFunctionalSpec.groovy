import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import page.AddressPage
import page.AddressSavePage
import page.LoginPage

@Stepwise
class AddressFunctionalSpec extends GebReportingSpec {
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

        submitButton.click()

        then: "I am being redirected to the same page with errors"
        at result
        alertSuccess

        where: "We have the next cases"
        country | street            | zipcode | neighborhood | county | town   | state     || result
        'aus'   | 'San Itario #666' | '43904' | 'Azteca'     | 'Apan' | 'Apan' | 'Hidalgo' || AddressSavePage
        'mex'   | 'San Itario #666' | '43904' | 'Azteca'     | 'Apan' | 'Apan' | 'Hidalgo' || AddressSavePage
    }

    def cleanupSpec() {}
}
