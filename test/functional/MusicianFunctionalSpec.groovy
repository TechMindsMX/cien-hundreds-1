import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import page.LoginPage
import page.MusicianPage
import page.MusicianSavePage
import page.MusicianShowPage

import page.ContactPage

import page.AddressPage
import page.AddressSavePage


@Stepwise
class MusicianFunctionalSpec extends GebReportingSpec {

    def grailsApplication

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "cien"
        loginForm.j_password = grailsApplication.config.password
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
        where: "We have the next cases"
        name    | history | web                           | notes  | tagsComma                    | formed       | genre| logo               || result
        // ''      | ''      | ''                            | ''     | ''                           | ''           | '1'  | ''                 || MusicianPage
        // 'luis'  | ''      | ''                            | ''     | ''                           | ''           | '1'  | ''                 || MusicianPage
        // 'luis1' | 'test'  | ''                            | ''     | ''                           | ''           | '1'  | ''                 || MusicianSavePage
        // 'luis2' | 'test'  | 'https://www.ironmaiden.com/' | ''     | ''                           | ''           | '1'  | ''                 || MusicianSavePage
        // 'luis3' | 'test'  | 'https://www.ironmaiden.com/' | 'test' | 'Heavy, Metal, Iron, Maiden' | ''           | '1'  | ''                 || MusicianSavePage
        // 'luis4' | 'test'  | 'https://www.ironmaiden.com/' | 'test' | 'Heavy, Metal, Iron, Maiden' | '27-06-2015' | '1'  | ''                 || MusicianShowPage
        // 'luis5' | 'test'  | 'https://www.ironmaiden.com/' | 'test' | 'Heavy, Metal, Iron, Maiden' | '28-06-2015' | '2'  | ''                 || MusicianShowPage
        'luis6' | 'test'  | 'https://www.ironmaiden.com/' | 'test' | 'Heavy, Metal, Iron, Maiden' | '29-06-2015' | '3'  | 'images/test.jpg' || MusicianShowPage

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
        name    | history | web                           | notes  | tagsComma                    | formed       | genre| logo               || result
        'luis7' | 'test'  | 'https://www.ironmaiden.com/' | 'test' | 'Heavy, Metal, Iron, Maiden' | '30-06-2015' | '2'  | '/images/test.jpg' || MusicianPage

    }

    @Unroll
    def "Fill Contact form"() {
        given:"form Contact create"
        contactCreate.click()

        when: "I fill the form fields"
        contactForm.firstName      = firstName
        contactForm.lastName       = lastName
        contactForm.motherLastName = motherLastName
        contactForm.other          = other
        contactForm.nationality    = nationality
        contactForm.biography      = biography
        contactForm.style          = style
        contactForm.birthDate      = birthDate
        contactForm.entryDate      = entryDate
        roleSelect                 = role
        contactForm.type           = type
        contactForm.file           = file

        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
        firstName | lastName   | motherLastName    | other   | nationality | biography   | style   | birthDate    | entryDate   | role | type   | file || result
        // ''        | ''         | ''                | ''      | ''          | ''          | ''      | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        // 'Luis'    | ''         | ''                | ''      | ''          | ''          | ''      | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        // 'Luis'    | 'lastName' | ''                | ''      | ''          | ''          | ''      | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        // 'Luis'    | 'lastName' | 'motherlastnname' | ''      | ''          | ''          | ''      | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        // 'Luis'    | 'lastName' | 'motherlastnname' | 'other' | ''          | ''          | ''      | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        // 'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'alb'       | ''          | ''      | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        // 'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'ago'       | 'biography' | ''      | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        // 'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'ata'       | 'biography' | 'style' | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        // 'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'bmu'       | 'biography' | 'style' | '28-03-1981' | ''          | '1'  | 'MALE' | ''   || ContactPage
        // 'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'vgb'       | 'biography' | 'style' | '28-03-1981' | '20-06-2015'| '1'  | 'MALE' | ''   || ContactPage
        // 'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'cxr'       | 'biography' | 'style' | '28-03-1981' | '20-06-2015'| '1'  | 'MALE' | ''   || ContactPage
        'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'mex'       | 'biography' | 'style' | '28-03-1981' | '20-06-2015'| '1'  | 'MALE' | ''   || ContactPage
    }

    // @Unroll
    // def "Fill Address form"() {
    //     given:"form Address create"
    //     to AddressPage

    //     when: "I fill the form fields"
    //     addressForm.country      = country
    //     addressForm.street       = street
    //     addressForm.zipcode      = zipcode

    //     js('jQuery("#zipcode").trigger("change")')

    //     addressForm.neighborhood = neighborhood
    //     addressForm.county       = county
    //     addressForm.town         = town
    //     addressForm.state        = state

    //     submitButton.click()

    //     then: "I am being redirected to the same page with errors"
    //     at result
    //     alertSuccess

    //     where: "We have the next cases"
    //     country | street            | zipcode | neighborhood | county | town   | state     || result
    //     'aus'   | 'San Itario #666' | '43904' | 'Azteca'     | 'Apan' | 'Apan' | 'Hidalgo' || AddressSavePage
    //     'mex'   | 'San Itario #666' | '43904' | 'Azteca'     | 'Apan' | 'Apan' | 'Hidalgo' || AddressSavePage
    // }


    def cleanupSpec() {}
}
