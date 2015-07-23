
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.htmlunit.HtmlUnitDriver

driver = {

  FirefoxProfile profile = new FirefoxProfile()
  profile.setPreference("intl.accept_languages", "en-us")
  def driverInstance = new FirefoxDriver(profile)
  driverInstance.manage().window().maximize()
  driverInstance

}

baseNavigatorWaiting = true
atCheckWaiting = true

/*
import org.openqa.selenium.htmlunit.HtmlUnitDriver

driver = {
  new HtmlUnitDriver()
}
*/