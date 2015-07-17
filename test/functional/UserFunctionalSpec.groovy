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
    userForm.password = 'aA12345678'
    userForm.passwordCheck = 'aA12345678'
    userForm.firstName = 'Jose Luis'
    userForm.motherLastName = 'De la Cruz'
    userForm.lastName = 'Morales'
    userForm.email = 'joseluis.delacruz@gmail.com'
    userForm.emailCheck = 'joseluis.delacruz@gmail.com'
    $("#create").click()
  then: "I am being redirected to the homepage"
    at UserSavePage
  }

  def "should create an account"() {
  given:"User page"
    to UserPage
  when: "I am entering user values"
    userForm.username = 'josdem'
    userForm.password = 'aA12345678'
    userForm.passwordCheck = 'aA12345678'
    userForm.firstName = 'Jose Luis'
    userForm.motherLastName = 'De la Cruz'
    userForm.lastName = 'Morales'
    userForm.email = 'joseluis.delacruz@gmail.com'
    userForm.emailCheck = 'joseluis.delacruz@gmail.com'
    $("#terms").click()
    $("#create").click()
  then: "I am being redirected to the homepage"
    at HomePage
  }

}
