import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import page.LoginPage
import page.HomePage

@Stepwise
class LoginSpec extends GebReportingSpec {

  def "Invalid admin login"() {
  given:"Login page"
    to LoginPage
  when: "I am entering invalid password"
    loginForm.j_username = "admin"
    loginForm.j_password = "87654321"
    $("#btn-success").click()
  then: "I am being redirected to the homepage"
    at LoginPage
    !loginForm.j_username
    !loginForm.j_password
  }

  def "Admin login"() {
  given:"Login page"
    to LoginPage
  when: "I am entering invalid password"
    loginForm.j_username = "admin"
    loginForm.j_password = "12345678"
    $("#btn-success").click()
  then: "I am being redirected to the homepage"
    at HomePage
  }

}
