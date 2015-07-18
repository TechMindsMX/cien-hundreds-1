import geb.spock.GebReportingSpec
import spock.lang.Stepwise

import page.UserPage
import page.UserSavePage
import page.HomePage

@Stepwise
class UserFunctionalSpec extends GebReportingSpec {

  def "should not create an account since user did not click in terms"() {
  given:"User page"
    to UserPage
  when: "I am entering user values"
    userForm.username = 'josdem'
    userForm.password = 'aA1234567!'
    userForm.passwordCheck = 'aA1234567!'
    userForm.firstName = 'Jose Luis'
    userForm.lastName = 'De la Cruz'
    userForm.motherLastName = 'Morales'
    userForm.email = 'qa@trama.mx'
    userForm.emailCheck = 'qa@trama.mx'
    $("#create").click()
  then: "I am being redirected to the homepage"
    at UserSavePage
  }

  def "should create an account"() {
  given:"User page"
    to UserPage
  when: "I am entering user values"
    userForm.username = 'josdem'
    userForm.password = 'aA1234567!'
    userForm.passwordCheck = 'aA1234567!'
    userForm.firstName = 'Jose Luis'
    userForm.lastName = 'De la Cruz'
    userForm.motherLastName = 'Morales'
    userForm.email = 'qa@trama.mx'
    userForm.emailCheck = 'qa@trama.mx'
    $("#terms").click()
    $("#create").click()
  then: "I am being redirected to the homepage"
    at HomePage
  }

}
