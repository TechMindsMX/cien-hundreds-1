import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Shared
import spock.lang.Unroll
import page.LoginPage
import page.MusicianPage
import page.MusicianSavePage
import page.MusicianShowPage

import page.ContactPage
import page.ContactShowPage

import page.AddressPage
import page.AddressSavePage

import page.SocialCreatePage
import page.SocialShowPage

import page.UserTelephonePage

@Stepwise
class MusicianFunctionalSpec extends GebReportingSpec {

    @Shared
    def grailsApplication = new org.codehaus.groovy.grails.commons.DefaultGrailsApplication()

    def setupSpec() {
        to LoginPage

        loginForm.j_username = "cien"
        loginForm.j_password = grailsApplication.config.tests.userPassword
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
        'luis6' | 'test'  | 'https://www.ironmaiden.com/' | 'test' | 'Heavy, Metal, Iron, Maiden' | '29-06-2015' | '3'  | 'images/test.jpg'  || MusicianShowPage

    }

    // @Unroll
    // def "Fill Form for Musician checkbox"() {
    //     given:"Create Musician Form"
    //     to MusicianPage

    //     when: "I do fill fields form"
    //     musicianForm.name      = name
    //     musicianForm.history   = history
    //     musicianForm.web       = web
    //     musicianForm.notes     = notes
    //     musicianForm.tagsComma = tagsComma
    //     musicianForm.formed    = formed
    //     select                 = genre
    //     musicianForm.find('[name="hasManager"]').click()
    //     musicianForm.logo      = logo

    //     then: "I am being redirected to the same page with errors"
    //     submitButton.click()

    //     where: "We have the next cases"
    //     name    | history | web                           | notes  | tagsComma                    | formed       | genre| logo               || result
    //     'luis7' | 'test'  | 'https://www.ironmaiden.com/' | 'test' | 'Heavy, Metal, Iron, Maiden' | '30-06-2015' | '2'  | '/images/test.jpg' || MusicianPage

    // }

    @Unroll
    def "Fill Contact form"() {
        given:"form Contact create"
        at MusicianShowPage
        contactCreate.click()

        when: "I fill the form fields"
        at ContactPage
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
        'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'mex'       | 'biography' | 'style' | '28-03-1981' | '20-06-2015'| '1'  | 'MALE' | ''   || ContactShowPage
    }

    @Unroll
    def "Fill UserTelephonePage form"() {
        given:"form UserTelephonePage create"
        at ContactShowPage
        addTelephone.click()
        at UserTelephonePage

        when: "I don't fill the form fields "
        userTelephoneForm.phone     = phone
        type                        = type
        userTelephoneForm.uuid      = uuid


        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
        phone        | type          | uuid                               || result
        // ''           | ''            | ''                                 || UserTelephonePage
        // '1234567890' | ''            | ''                                 || UserTelephonePage
        // '12345678'   | ''            | ''                                 || UserTelephonePage
        // '12345678901'| ''            | ''                                 || UserTelephonePage
        // '1234567890' | 'WORK'        | ''                                 || UserTelephonePage
        // '1234567890' | 'WORK'        | ''                                 || UserTelephonePage
        // '1234567890' | 'WORK'        | ''                                 || UserTelephonePage
        // '1234567890' | 'WORK'        | ''                                 || UserTelephonePage
        // '1234567890' | 'WORK'        | '7d0f82f'                          || UserTelephonePage
        '1234567890' | 'WORK'        | '7d0f82fbb0ba4beabda87d25914590c9' || ContactShowPage
    }

    @Unroll
    def "Fill Social form"() {
        given:"navigate to form Social create"
        at ContactShowPage
        backToMusician.click()
        at MusicianShowPage
        socialCreate.click()
        at SocialCreatePage

        when: "I fill the form fields"
        socialForm.facebook     = facebook
        socialForm.twitter      = twitter
        socialForm.googlePlus   = googlePlus 
        socialForm.instagram    = instagram
        socialForm.youtube      = youtube 
        socialForm.linkedin     = linkedin 
        socialForm.other        = other 

        submitButton.click()

        then: "I am being redirected to the show page with success message"
        at result
        alertSuccess

        where: "We have the next cases"
        facebook                         | twitter                    | googlePlus                        | instagram                       | youtube                               | linkedin                                  | other                                 || result
        'https://www.facebook.com/Sony'  | 'https://twitter.com/sony' | 'https://plus.google.com/+Sony'   | 'https://instagram.com/sony/'   | 'https://www.youtube.com/user/Sony'   | 'https://www.linkedin.com/company/sony'   | 'https://en.wikipedia.org/wiki/Sony'  || SocialShowPage

    }


    // @Unroll
    // def "Fill Address form"() {
    //     given:"form Address create"
    //     backToMusician.click()
    //     createAddress.click()

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
