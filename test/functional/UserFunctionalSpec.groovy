import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import page.UserPage

@Stepwise
class UserFunctionalSpec extends GebReportingSpec {

  def "should create an account"() {
  given:"User page"
    to UserPage
  when: "I am entering all values"
    userForm.username = 'josdem'
    userForm.password = 'aA12345678'
    userForm.passwordCheck = 'aA12345678'
    userForm.firstName = 'Jose Luis'
    userForm.middleName = 'De la Cruz'
    userForm.lastName = 'Morales'
    userForm.email = 'josdem@email.com'
    userForm.emailCheck = 'josdem@email.com'
    $("#create").click()
  then: "I am being redirected to the homepage"
    at UserPage
  }

}
