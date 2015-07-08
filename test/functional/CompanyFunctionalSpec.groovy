import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import page.LoginPage
import page.CompanyPage

@Stepwise
class CompanyFunctionalSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = "12345678"
        loginButton.click()
    }

    @Unroll
    def "Fill Form for Campany"() {
        given:"Create Company Form"
        to CompanyPage
        when: "I do fill fields form with"
        companyForm.name        = name
        companyForm.description = description
        companyForm.web         = web
        companyForm.notes       = notes
        companyForm.tags        = tags

        then: "I am being redirected to the same page with errors"
        submitButton.click()

        where: "We have the next cases"
        name   | description | web                      | notes  | tags          | logo | corporatePress || result
        ''     | ''          | ''                       | ''     | ''            | ''   |  ''            ||CompanyPage
        'Test' | ''          | ''                       | ''     | ''            | ''   |  ''            ||CompanyPage
        'Test' | 'test'      | ''                       | ''     | ''            | ''   |  ''            ||CompanyPage
        'Test' | 'test'      | 'http://www.susitio.com' | ''     | ''            | ''   |  ''            ||CompanyPage
        'Test' | 'test'      | 'www.susitio.com'        | ''     | ''            | ''   |  ''            ||CompanyPage
        'Test' | 'test'      | 'http://susitio.com'     | ''     | ''            | ''   |  ''            ||CompanyPage
        'Test' | 'test'      | 'http://www.susitio.com' | 'test' | ''            | ''   |  ''            ||CompanyPage
        'Test' | 'test'      | 'http://www.susitio.com' | 'test' | 'test,prueba' | ''   |  ''            ||CompanyPage

    }

    def cleanupSpec() {}
}
