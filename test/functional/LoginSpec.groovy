import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class LoginSpec extends GebReportingSpec {

  def "admin login"() {
  when:
    to LoginPage
  then:
    1 == 1
  }

}
