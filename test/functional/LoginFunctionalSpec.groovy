import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Shared

import page.LoginPage
import page.HomePage

@Stepwise
class LoginFunctionalSpec extends GebReportingSpec {

    @Shared
    def grailsApplication = new org.codehaus.groovy.grails.commons.DefaultGrailsApplication()

  def "Invalid admin login"() {
    given:"Login page"
      to LoginPage
    when: "I am entering invalid password"
      loginForm.j_username = "admin"
      loginForm.j_password = "87654321"
      loginButton.click()
    then: "I am being redirected to the homepage"
      at LoginPage
      !loginForm.j_username
      !loginForm.j_password
  }

  def "Admin login"() {
    given:"Login page"
    to LoginPage
    when: "I am entering valid password"
    loginForm.j_username = "admin"
    loginForm.j_password = grailsApplication.config.tests.userPassword
    loginButton.click()
    then: "I am being redirected to the homepage"
    at HomePage
  }

}
