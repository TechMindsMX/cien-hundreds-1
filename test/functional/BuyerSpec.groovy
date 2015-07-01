import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import spock.lang.Unroll
import page.LoginPage
import page.BuyerPage
import page.BuyerSavePage

@Stepwise
class BuyerSpec extends GebReportingSpec {

    def setupSpec() {
        to LoginPage
        loginForm.j_username = "admin"
        loginForm.j_password = "12345678"
        loginButton.click()
    }

    @Unroll
    def "Empty Form Buyer"() {
        given:"form Buyer create"
        to BuyerPage
        when: "I do not fill form fields "
        buyerForm.username = username
        buyerForm.password = password
        buyerForm.passwordCheck = passwordCheck
        buyerForm.firstName = firstName
        buyerForm.middleName = middleName
        buyerForm.lastName = lastName
        buyerForm.phone = phone
        buyerForm.email = email
        buyerForm.emailCheck = emailCheck
        buyerForm.role = role
        submitButton.click();
        then: "I am being redirected to the same page whit errors"
        at result
        where: "We have the next cases"
        username | password       | passwordCheck  | firstName  | middleName | lastName | phone        | email                         | emailCheck                    | role         || result
        ''       |''              |''              |''          |''          |''        |''            |''                             |''                             | 'ROLE_BUYER' || BuyerSavePage
        'luis'   |''              |''              |''          |''          |''        |''            |''                             |''                             | 'ROLE_BUYER' || BuyerSavePage
        'luis'   |'Valhalla5227@' |''              |''          |''          |''        |''            |''                             |''                             | 'ROLE_BUYER' || BuyerSavePage
        'luis'   |'Valhalla5227@' |'Valhalla5227@' |''          |''          |''        |''            |''                             |''                             | 'ROLE_BUYER' || BuyerSavePage
        'luis'   |'Valhalla5227@' |'Valhalla5227@' |'Luis'      |''          |''        |''            |''                             |''                             | 'ROLE_BUYER' || BuyerSavePage
        'luis'   |'Valhalla5227@' |'Valhalla5227@' |'Luis'      |'Magana'    |''        |''            |''                             |''                             | 'ROLE_BUYER' || BuyerSavePage
        'luis'   |'Valhalla5227@' |'Valhalla5227@' |'Luis'      |'Magana'    |'Manzano' |''            |''                             |''                             | 'ROLE_BUYER' || BuyerSavePage
        'luis'   |'Valhalla5227@' |'Valhalla5227@' |'Luis'      |'Magana'    |'Manzano' |'55123456789' |''                             |''                             | 'ROLE_BUYER' || BuyerSavePage
        'luis'   |'Valhalla5227@' |'Valhalla5227@' |'Luis'      |'Magana'    |'Manzano' |'55123456789' |'luis.magana@techminds.com.mx' |''                             | 'ROLE_BUYER' || BuyerSavePage
        'luis'   |'Valhalla5227@' |'Valhalla5227@' |'Luis'      |'Magana'    |'Manzano' |'55123456789' |'luis.magana@techminds.com.mx' |'luis.magana@techminds.com.mx' | 'ROLE_BUYER' || BuyerSavePage
        'luis'   |'Valhalla5227@' |'Valhalla5227'  |'Luis'      |'Magana'    |'Manzano' |'55123456789' |'luis.magana@techminds.com.mx' |'luis.magana@techminds.com.mx' | 'ROLE_BUYER' || BuyerSavePage
        'luis'   |'Valhalla5227@' |'Valhalla5227'  |'Luis'      |'Magana'    |'Manzano' |'55123456789' |'luis.magana@techminds.com.mx' |'luis.magana@techminds.com.mx' | 'ROLE_BUYER' || BuyerSavePage
        'luis'   |'Valhalla5227@' |'Valhalla5227'  |'Luis'      |'Magana'    |'Manzano' |'55123456789' |'luis.magana@techminds.com.mx' |'luis.magana@techminds.com.mx' | 'ROLE_BUYER' || BuyerSavePage
    }

    def cleanupSpec() {}
}
