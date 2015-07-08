import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import page.LoginPage
import page.MusicianPage

import page.AddressPage
import page.AddressSavePage


@Stepwise
class MusicianFunctionalSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "cien"
        loginForm.j_password = "12345678"
        loginButton.click()
    }

    @Unroll
    def "Fill Form for Musician"() {
        given:"Create Musician Form"
        to MusicianPage
        when: "I do fill fields form"
        musicianForm.name      = name
        musicianForm.history   = history
        musicianForm.web       = web
        musicianForm.notes     = notes
        musicianForm.tagsComma = tagsComma
        musicianForm.formed    = formed
        musicianForm.logo      = logo
        select                 = genre
        then: "I am being redirected to the same page with errors"
        submitButton.click()
        at MusicianPage
        where: "We have the next cases"
        name    | history | web                           | notes  | tagsComma                    | formed       | genre| logo                                                                       || result
        ''      | ''      | ''                            | ''     | ''                           | ''           | '1'  | ''                                                                         || MusicianPage
        'luis'  | ''      | ''                            | ''     | ''                           | ''           | '1'  | ''                                                                         || MusicianPage
        'luis1' | 'test'  | ''                            | ''     | ''                           | ''           | '1'  | ''                                                                         || MusicianPage
        'luis2' | 'test'  | 'https://www.ironmaiden.com/' | ''     | ''                           | ''           | '1'  | ''                                                                         || MusicianPage
        'luis3' | 'test'  | 'https://www.ironmaiden.com/' | 'test' | 'Heavy, Metal, Iron, Maiden' | ''           | '1'  | ''                                                                         || MusicianPage
        'luis4' | 'test'  | 'https://www.ironmaiden.com/' | 'test' | 'Heavy, Metal, Iron, Maiden' | '27-06-2015' | '1'  | ''                                                                         || MusicianPage
        'luis5' | 'test'  | 'https://www.ironmaiden.com/' | 'test' | 'Heavy, Metal, Iron, Maiden' | '28-06-2015' | '2'  | ''                                                                         || MusicianPage
        'luis6' | 'test'  | 'https://www.ironmaiden.com/' | 'test' | 'Heavy, Metal, Iron, Maiden' | '29-06-2015' | '3'  | 'C:\\Users\\lutek\\Pictures\\2015_ford_shelby_gt350_mustang-1920x1080.jpg' || MusicianPage

    }

    @Unroll
    def "Fill Form for Musician checkbox"() {
        given:"Create Musician Form"
        to MusicianPage

        when: "I do fill fields form"
        musicianForm.name      = name
        musicianForm.history   = history
        musicianForm.web       = web
        musicianForm.notes     = notes
        musicianForm.tagsComma = tagsComma
        musicianForm.formed    = formed
        select                 = genre
        musicianForm.find('[name="hasManager"]').click()
        musicianForm.logo      = logo

        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
        name    | history | web                           | notes  | tagsComma                    | formed       | genre| logo                                                                       || result
        'luis7' | 'test'  | 'https://www.ironmaiden.com/' | 'test' | 'Heavy, Metal, Iron, Maiden' | '30-06-2015' | '2'  | 'C:\\Users\\lutek\\Pictures\\2015_ford_shelby_gt350_mustang-1920x1080.jpg' || MusicianPage

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
