import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import page.LoginPage
import page.HomePage

@Stepwise
class LoginSpec extends GebReportingSpec {

  def "admin login"() {
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
