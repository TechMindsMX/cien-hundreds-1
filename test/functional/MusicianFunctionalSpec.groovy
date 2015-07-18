import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Shared
import spock.lang.Unroll

import page.LoginPage
import page.LogoutPage

import page.MusicianPage
import page.MusicianSavePage
import page.MusicianShowPage

import page.ContactPage
import page.ContactShowPage

import page.AddressFormPage
import page.AddressShowPage

import page.SocialCreatePage
import page.SocialShowPage

import page.ActivityFormPage
import page.ActivityShowPage

import page.PrepareTelephoneFormPage

import page.PrepareEmailFormPage

import page.VideoFormPage
import page.VideoShowPage

import page.AudioFormPage
import page.AudioShowPage

import page.PhotoFormPage
import page.PhotoShowPage

// TODO: carga de archivo, Address y Sociall links para volver al objeto padre

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
        name    | history | web                           | notes  | tagsComma                    | formed       | genre| logo                                          || result
        'luis7' | 'test'  | 'https://www.ironmaiden.com/' | 'test' | 'Heavy, Metal, Iron, Maiden' | '30-06-2015' | '2'  | grailsApplication.config.tests.filesPath.jpg  || MusicianPage

    }

    @Unroll
    def "Fill Video form"() {
        given:"form Video create"
        at MusicianShowPage
        addVideo.click()
        at VideoFormPage

        when: "I don't fill the form fields "
        videoForm.url = siteUrl

        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
        siteUrl                                       || result
        'https://www.youtube.com/watch?v=wP1zAyibHm8' || VideoShowPage
    }

    @Unroll
    def "Fill Audio form"() {
        given:"form Audio create"
        at VideoShowPage
        backToMusician.click()
        at MusicianShowPage
        addAudio.click()
        to AudioFormPage

        when: "I fill the Audio form"
        audioForm.url = url

        then: "I am being redirected to the same page with errors or redirect to view Audio page."
        submitButton.click()

        where: "We have the next cases"
        url                                                                  || result
        'https://soundcloud.com/metalbladerecords/act-of-defiance-throwback' || AudioShowPage //Pass
    }

    @Unroll
    def "Fill Photo form"() {
        given:"form Photo create"
        at AudioShowPage
        backToMusician.click()
        at MusicianShowPage
        addPhoto.click()
        to PhotoFormPage

        when: "I fill the Photo form"
        photoForm.file = file

        then: "I am being redirected to the same page with errors or redirect to view Photo page."
        submitButton.click()

        where: "We have the next cases"
        file                                           || result
        grailsApplication.config.tests.filesPath.jpg   || PhotoShowPage //Pass
    }

    // @Unroll
    // def "Fill Social form for Musician"() {
    //     given:"navigate to form Social create"
    //     at PhotoShowPage
    //     backToMusician.click()
    //     at MusicianShowPage
    //     addSocial.click()
    //     at SocialCreatePage

    //     when: "I fill the form fields"
    //     socialForm.facebook     = facebook
    //     socialForm.twitter      = twitter
    //     socialForm.googlePlus   = googlePlus 
    //     socialForm.instagram    = instagram
    //     socialForm.youtube      = youtube 
    //     socialForm.linkedin     = linkedin 
    //     socialForm.other        = other 

    //     submitButton.click()

    //     then: "I am being redirected to the show page with success message"
    //     at result
    //     alertSuccess

    //     where: "We have the next cases"
    //     facebook                         | twitter                    | googlePlus                        | instagram                       | youtube                               | linkedin                                  | other                                 || result
    //     'https://www.facebook.com/Sony'  | 'https://twitter.com/sony' | 'https://plus.google.com/+Sony'   | 'https://instagram.com/sony/'   | 'https://www.youtube.com/user/Sony'   | 'https://www.linkedin.com/company/sony'   | 'https://en.wikipedia.org/wiki/Sony'  || SocialShowPage
    // }

    @Unroll
    def "Fill Activity form"() {
        given:"form Activity create"
        at PhotoShowPage
        backToMusician.click()
        at MusicianShowPage
        addActivity.click()
        at ActivityFormPage

        when: "I don't fill form fields "
        activityForm.activity = activity
        activityForm.date = date
        activityForm.place = place

        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
        activity            | place    | date               || result
        'no hacer nada'     |  'algo'  | '20-06-2015'       || ActivityShowPage
    }

    @Unroll
    def "Fill Contact form"() {
        given:"form Contact create"
        at ActivityShowPage
        backToMusician.click()
        at MusicianShowPage
        addContact.click()

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
        firstName | lastName   | motherLastName    | other   | nationality | biography   | style   | birthDate    | entryDate   | role | type   | file                                          || result
        'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'mex'       | 'biography' | 'style' | '28-03-1981' | '20-06-2015'| '1'  | 'MALE' | grailsApplication.config.tests.filesPath.jpg  || ContactShowPage
    }

    @Unroll
    def "Fill PrepareTelephoneFormPage form"() {
        given:"form PrepareTelephoneFormPage create"
        at ContactShowPage
        addTelephone.click()
        at PrepareTelephoneFormPage

        when: "I fill the form fields "
        userTelephoneForm.phone     = phone
        type                        = type

        then: "I submit the form"
        submitButton.click()

        where: "We expect a result for the next cases"
        phone        | type           || result
        '1234567890' | 'WORK'         || ContactShowPage
    }

    @Unroll
    def "Fill PrepareEmailPage form"() {
        given:"form UserEmailPage create"
        at ContactShowPage
        addEmail.click()
        at PrepareEmailFormPage

        when: "I fill the form fields "
        emailForm.address     = address
        type                  = type

        then: "I submit the form"
        submitButton.click()

        where: "We expect a result for the next cases"
        address             | type          || result
        'correo@correo.com' | 'WORK'        || ContactShowPage
    }

    // @Unroll
    // def "Fill Social form for Musician Contact"() {
    //     given:"navigate to form Social create"
    //     at ContactShowPage
    //     addSocial.click()
    //     at SocialCreatePage

    //     when: "I fill the form fields"
    //     socialForm.facebook     = facebook
    //     socialForm.twitter      = twitter
    //     socialForm.googlePlus   = googlePlus 
    //     socialForm.instagram    = instagram
    //     socialForm.youtube      = youtube 
    //     socialForm.linkedin     = linkedin 
    //     socialForm.other        = other 

    //     submitButton.click()

    //     then: "I am being redirected to the show page with success message"
    //     at result
    //     alertSuccess

    //     where: "We have the next cases"
    //     facebook                         | twitter                    | googlePlus                        | instagram                       | youtube                               | linkedin                                  | other                                 || result
    //     'https://www.facebook.com/Sony'  | 'https://twitter.com/sony' | 'https://plus.google.com/+Sony'   | 'https://instagram.com/sony/'   | 'https://www.youtube.com/user/Sony'   | 'https://www.linkedin.com/company/sony'   | 'https://en.wikipedia.org/wiki/Sony'  || SocialShowPage

    // }

    @Unroll
    def "Fill Address form for Musician Contact"() {
        given:"form Address create"
        at ContactShowPage
        addAddress.click()
        at AddressFormPage

        when: "I fill the form fields"
        addressForm.country      = country
        addressForm.street       = street
        addressForm.zipcode      = zipcode
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
        'alb'   | 'San Itario #666' | '43904' | 'Azteca'     | 'Apan' | 'Apan' | 'Hidalgo' || AddressShowPage
    }


    def cleanupSpec() {
        to LogoutPage
    }
}
