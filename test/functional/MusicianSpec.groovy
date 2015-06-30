import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import page.LoginPage
import page.MusicianPage

@Stepwise
class MusicianSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
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
        musicianForm.logo      = logo
        then: "I am being redirected to the same page whit errors"
        submitButton.click()
        at MusicianPage
        where: "We have the next cases"
        name     | history              | web           | notes     | tagsComma | logo                                                                      || result
        ''       | ''                   | ''            | ''        | ''        | ''                                                                        || MusicianPage
        'luis'   | ''                   | ''            | ''        | ''        | ''                                                                        || MusicianPage
        ''       | ''                   | ''            | ''        | ''        | 'C:\\Users\\lutek\\Pictures\\2015_ford_shelby_gt350_mustang-1920x1080.jpg'|| MusicianPage

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
        musicianForm.find('[name="hasManager"]').click()
        then: "I am being redirected to the same page whit errors"
        submitButton.click()
        at MusicianPage
        where: "We have the next cases"
        name     | history  | web           | notes     | tagsComma || result
        'Luis'   | ''       | ''            | ''        | ''        || MusicianPage

    }

    def cleanupSpec() {}
}
