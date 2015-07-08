import geb.spock.GebReportingSpec

import spock.lang.Stepwise
import spock.lang.Unroll
import page.ContactPage
import page.LoginPage

@Stepwise
class ContactFunctionalSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = "12345678"
        loginButton.click()
    }

    @Unroll
    def "Fill Contact form"() {
        given:"form Contact create"
        to ContactPage

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
        ''        | ''         | ''                | ''      | ''          | ''          | ''      | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        'Luis'    | ''         | ''                | ''      | ''          | ''          | ''      | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        'Luis'    | 'lastName' | ''                | ''      | ''          | ''          | ''      | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        'Luis'    | 'lastName' | 'motherlastnname' | ''      | ''          | ''          | ''      | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        'Luis'    | 'lastName' | 'motherlastnname' | 'other' | ''          | ''          | ''      | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'alb'       | ''          | ''      | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'ago'       | 'biography' | ''      | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'ata'       | 'biography' | 'style' | ''           | ''          | '1'  | 'MALE' | ''   || ContactPage
        'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'bmu'       | 'biography' | 'style' | '28-03-1981' | ''          | '1'  | 'MALE' | ''   || ContactPage
        'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'vgb'       | 'biography' | 'style' | '28-03-1981' | '20-06-2015'| '1'  | 'MALE' | ''   || ContactPage
        'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'cxr'       | 'biography' | 'style' | '28-03-1981' | '20-06-2015'| '1'  | 'MALE' | ''   || ContactPage
        'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'mex'       | 'biography' | 'style' | '28-03-1981' | '20-06-2015'| '1'  | 'MALE' | ''   || ContactPage
    }

    def cleanupSpec() {}
}
