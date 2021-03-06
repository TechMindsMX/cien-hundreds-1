import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import spock.lang.Shared
import spock.lang.Ignore

import page.LoginPage

import page.GenreCreatePage
import page.GenreSavePage
import page.GenreShowPage
/**
TODO: Probar con una versión más nueva de HtmlUnitDriver 
**/
@Ignore
@Stepwise
class GenreFunctionalSpec extends GebReportingSpec {

    @Shared
    def grailsApplication = new org.codehaus.groovy.grails.commons.DefaultGrailsApplication()

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = grailsApplication.config.tests.userPassword
        loginButton.click()
    }

    @Unroll
    def "Fill Genre form"() {
        given:"form Genre create"
        to GenreCreatePage

        when: "I do not fill form fields "
        genreForm.name = name
        submitButton.click()

        then: "I am being redirected to the same page with errors"
        at result

        where: "We have the next cases"
         name         || result
        ''            || GenreCreatePage
        'Heavy Metal' || GenreShowPage
    }

    def cleanupSpec() {}
}
