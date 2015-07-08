import geb.spock.GebReportingSpec

import spock.lang.Stepwise
import spock.lang.Unroll
import page.LoginPage
import page.GenrePage
import page.GenreShowPage

@Stepwise
class GenreFunctionalSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = "12345678"
        loginButton.click()
    }

    @Unroll
    def "Fill Genre form"() {
        given:"form Genre create"
        to GenrePage

        when: "I do not fill form fields "
        genreForm.name = name
        submitButton.click()

        then: "I am being redirected to the same page with errors"
        at result
        if(result == GenreShowPage){
            spanDato.text() == 'algo'
        }

        where: "We have the next cases"
         name         || result
        ''            || GenrePage
        'Heavy Metal' || GenreShowPage
    }

    def cleanupSpec() {}
}
