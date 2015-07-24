import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Shared
import spock.lang.Unroll

import page.LoginPage
import page.LogoutPage

import page.MusicianCreatePage
import page.MusicianSavePage
import page.MusicianShowPage

import page.VideoFormPage
import page.VideoShowPage

import page.AudioFormPage
import page.AudioShowPage

import page.PhotoFormPage
import page.PhotoShowPage

import page.AddressFormPage
import page.AddressShowPage

import page.SocialCreatePage
import page.SocialShowPage

import page.ActivityFormPage
import page.ActivityShowPage

import page.SuggestionShowPage
import page.SuggestionCreatePage

import page.ContactPage
import page.ContactShowPage

import page.PrepareTelephoneFormPage

import page.PrepareEmailFormPage

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

    def """Fill Form for Musician checkbox"""() {
        given:"Create Musician Form"
        to MusicianCreatePage

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

        submitButton.click()
        then: "I am being redirected to the same page with errors"
        at result
        alertSuccess

        where: "We have the next cases"
        name    | history | web                           | notes  | tagsComma                    | formed       | genre| logo                                          || result
        'luis7' | 'test'  | 'https://www.ironmaiden.com/' | 'test' | 'Heavy, Metal, Iron, Maiden' | '30-06-2015' | '2'  | grailsApplication.config.tests.filesPath.jpg  || MusicianShowPage

    }

    @Unroll
    def """Fill Video form for Musician"""() {
        given:"form Video create"
        at MusicianShowPage
        addVideo.click()
        at VideoFormPage

        when: "I don't fill the form fields "
        videoForm.url = siteUrl

        submitButton.click()
        then: "I am being redirected to the same page with errors"
        at result
        alertSuccess

        where: "We have the next cases"
        siteUrl                                       || result
        'https://www.youtube.com/watch?v=wP1zAyibHm8' || VideoShowPage
    }

    @Unroll
    def """Fill Audio form for Musician"""() {
        given:"form Audio create"
        at VideoShowPage
        backToMusician.click()
        at MusicianShowPage
        addAudio.click()
        to AudioFormPage

        when: "I fill the Audio form"
        audioForm.url = url

        submitButton.click()
        then: "I am being redirected to the same page with errors or redirect to view Audio page."
        at result
        alertSuccess

        where: "We have the next cases"
        url                                                                  || result
        'https://soundcloud.com/metalbladerecords/act-of-defiance-throwback' || AudioShowPage //Pass
    }

    @Unroll
    def """Fill Photo form for Musician"""() {
        given:"form Photo create"
        at AudioShowPage
        backToMusician.click()
        at MusicianShowPage
        addPhoto.click()
        to PhotoFormPage

        when: "I fill the Photo form"
        photoForm.file = file

        submitButton.click()
        then: "I am being redirected to the same page with errors or redirect to view Photo page."
        at result
        alertSuccess

        where: "We have the next cases"
        file                                           || result
        grailsApplication.config.tests.filesPath.jpg   || PhotoShowPage //Pass
    }

    @Unroll
    def """Fill Social form for Musician"""() {
        given:"navigate to form Social create"
        at PhotoShowPage
        backToMusician.click()
        at MusicianShowPage
        addSocial.click()
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

    @Unroll
    def """Fill Activity form for Musician"""() {
        given:"form Activity create"
        at SocialShowPage
        backToMusician.click()
        at MusicianShowPage
        addActivity.click()
        at ActivityFormPage

        when: "I don't fill form fields "
        activityForm.activity = activity
        activityForm.date = date
        activityForm.place = place

        submitButton.click()
        then: "I am being redirected to the same page with errors"
        at result
        alertSuccess

        where: "We have the next cases"
        activity            | place    | date               || result
        'no hacer nada'     |  'algo'  | '20-06-2015'       || ActivityShowPage
    }

    @Unroll
    def """Fill Suggestion form for Musician"""() {
        given:"form Activity create"
        at ActivityShowPage
        backToMusician.click()
        at MusicianShowPage
        addSuggestion.click()
        at SuggestionCreatePage

        when: "I don't fill form fields "
        suggestionForm.name = name
        suggestionForm.contactName = contactName
        suggestionForm.email = email
        suggestionForm.phone = phone

        submitButton.click()
        then: "I am being redirected to the same page with errors"
        at result
        alertSuccess

        where: "We have the next cases"
        name            | contactName    | email             | phone        || result
        'no hacer nada' | 'El contacto'  | 'email@email.com' | '1234567890' || SuggestionShowPage
    }

    @Unroll
    def """Fill Contact form for Musician"""() {
        given:"form Contact create"
        at SuggestionShowPage
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
        contactForm.mail           = mail
        contactForm.phone          = phone
        roleSelect                 = role
        contactForm.type           = type
        contactForm.file           = file
        submitButton.click()

        then: "I am being redirected to the same page with errors"
        at result
        alertSuccess

        where: "We have the next cases"
        firstName | lastName   | motherLastName    | other   | nationality | biography   | style   | birthDate    | entryDate   | mail           | phone        | role | type   | file                                          || result
        'Luis'    | 'lastName' | 'motherlastnname' | 'other' | 'mex'       | 'biography' | 'style' | '28-03-1981' | '20-06-2015'| 'mail@mail.com'| '1234567890' | '1'  | 'MALE' | grailsApplication.config.tests.filesPath.jpg  || ContactShowPage
    }

    @Unroll
    def """Fill PrepareTelephoneFormPage form for Musician Contact"""() {
        given:"form PrepareTelephoneFormPage create"
        at ContactShowPage
        addTelephone.click()
        at PrepareTelephoneFormPage

        when: "I fill the form fields "
        userTelephoneForm.phone     = phone
        type                        = type

        submitButton.click()
        then: "I submit the form"
        at result
        alertSuccess

        where: "We expect a result for the next cases"
        phone        | type           || result
        '1234567890' | 'WORK'         || ContactShowPage
    }

// 9
    @Unroll
    def "Fill PrepareEmailPage form for Musician Contact"() {
        given:"form UserEmailPage create"
        at ContactShowPage
        addEmail.click()
        at PrepareEmailFormPage

        when: "I fill the form fields "
        emailForm.mail     = mail
        type                  = type

        submitButton.click()
        then: "I submit the form"
        at result
        alertSuccess

        where: "We expect a result for the next cases"
        mail                | type          || result
        'correo@correo.com' | 'WORK'        || ContactShowPage
    }

// 10
    @Unroll
    def "Fill Social form for Musician Contact"() {
        given:"navigate to form Social create"
        at ContactShowPage
        addSocial.click()
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

// 11
    @Unroll
    def "Fill Address form for Musician Contact"() {
        given:"form Address create"
        at SocialShowPage
        backToContact.click()
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
