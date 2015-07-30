import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import spock.lang.Shared

import page.LoginPage

import page.CompanyCreatePage
import page.CompanyShowPage
import page.CompanySavePage
import page.CompanyIndexPage

import page.ProductCreatePage
import page.ProductSavePage
import page.ProductShowPage

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
        companyForm.logo           = logo
        companyForm.corporatePress = corporatePress

        submitButton.click()
        then: "I am being redirected to the same page with errors"
        at result
        alertSuccess

        where: "We have the next cases"
        name   | description | web                      | notes  | tags          | logo                                         | corporatePress                               || result
        'Test' | 'test'      | 'http://www.susitio.com' | 'test' | 'test,prueba' | grailsApplication.config.tests.filesPath.jpg | ''                                           || CompanyShowPage
        'Test' | 'test'      | 'http://www.susitio.com' | 'test' | 'test,prueba' | ''                                           | grailsApplication.config.tests.filesPath.pdf || CompanyShowPage
    }

    def """Go to the form for company product"""() {
        given: "I see the company details page"
        at CompanyShowPage
        when: "I click on the create product link"
        createProduct.click()
        then: "I should see the product form"
        at ProductCreatePage
    }

    def """Fill the form incorrectlly for company product"""() {
        given: "I am at the company product page"
        at ProductCreatePage
        when: "I fill the create product form"
        form.name = "el dato name"
        form.description = "el dato description"
        form.benefits = "el dato benefits"
        form.target = "el dato target"
        form.competence = "el dato competence"
        form.videoLink = "el dato videoLink"
        form.discountModel = "el dato discountModel"
        form.clients = "el dato clients"
        form.distributionModel = "el dato distributionModel"
        form.salesModel = "el dato salesModel"
        form.customerModel = "el dato customerModel"
        form.postSaleModel = "el dato postSaleModel"
        form.notes = "el dato notes"
        form.find('[name="campaign"]').click()
        form.campaignDescription = "el dato campaignDescription"
        form.find('[name="event"]').click()
        form.eventDescription = "el dato eventDescription"
        form.find('[name="other"]').click()
        form.otherDescription = "el dato otherDescription"
        form.find('[name="telephone"]').click()
        form.telephoneDescription = "el dato telephoneDescription"
        form.find('[name="web"]').click()
        form.webDescription = "el dato webDescription"
        and: "I submit the form"
        submitButton.click()
        then: "I should see validation errors"
        at ProductSavePage
        alertErrors
    }

    def """Fill the form for company product"""() {
        given: "I am at the company product form"
        at ProductSavePage
        when: "I fill the create product form"
        form.videoLink = "https://youtu.be/c9_9y9zBRVQ"
        // form.campaignDescription = "el dato campaignDescription"
        // form.eventDescription = "el dato eventDescription"
        // form.otherDescription = "el dato otherDescription"
        // form.telephoneDescription = "el dato telephoneDescription"
        // form.webDescription = "el dato webDescription"
        and: "I submit the form"
        submitButton.click()
        then: "I should see the product details"
        at ProductShowPage
        alertSuccess
    }

    def """List the Company on the index view"""() {
        given: "we are at company details"
        backToCompany.click()
            at CompanyShowPage
        when: "we go to the list of companies"
            companyListBtn.click()
        then:
            at CompanyIndexPage
            
    }

    def cleanupSpec() {}
}
