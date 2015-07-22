import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import spock.lang.Shared

import page.LoginPage

import page.CompanyCreatePage
import page.CompanyShowPage
import page.CompanySavePage

@Stepwise
class CompanyFunctionalSpec extends GebReportingSpec {

    @Shared
    def grailsApplication = new org.codehaus.groovy.grails.commons.DefaultGrailsApplication()

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "cien"
        loginForm.j_password = grailsApplication.config.tests.userPassword
        loginButton.click()
    }

// 1
    @Unroll
    def """Fill Form for Company with name #name, description #description, web #web, notes #notes, tags #tags, logo #logo, corporatePress #corporatePress, we expect #result """() {
        given:"Create Company Form"
        to CompanyCreatePage
        when: "I do fill fields form with"
        companyForm.name           = name
        companyForm.description    = description
        companyForm.web            = web
        companyForm.notes          = notes
        companyForm.tagsComma      = tags
        companyForm.corporatePress = corporatePress

        submitButton.click()
        then: "I am being redirected to the same page with errors"
        at result

        where: "We have the next cases"
        name   | description | web                      | notes  | tags          | logo                                           | corporatePress                               || result
        ''     | ''          | ''                       | ''     | ''            | ''                                             | ''                                           || CompanySavePage
        'Test' | ''          | ''                       | ''     | ''            | ''                                             | ''                                           || CompanySavePage
        'Test' | 'test'      | 'http://www.susitio.com' | 'test' | 'test,prueba' | grailsApplication.config.tests.filesPath.jpg   | grailsApplication.config.tests.filesPath.pdf || CompanyShowPage
    }

    def cleanupSpec() {}
}
