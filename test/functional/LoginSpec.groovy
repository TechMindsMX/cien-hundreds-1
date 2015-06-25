import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class LoginSpec extends GebReportingSpec {

def "invalid login"() {
given: "I am at the login page"
to LoginPage

when: "I am entering invalid password"
loginForm.j_username = "me@gmail.com"
loginForm.j_password = "ioguffwf"
loginButton.click()

then: "I am being redirected to the login page"
at LoginPage
!loginForm.j_username
!loginForm.j_password
}

def "admin login"() {
given : "I am at the login page"
to LoginPage

when: "I am entering valid username and password"
loginForm.j_username = "me@gmail.com"
loginForm.j_password = "me"
loginButton.click()

then: "I am being redirected to the homepage"
at HomePage
  }
}
