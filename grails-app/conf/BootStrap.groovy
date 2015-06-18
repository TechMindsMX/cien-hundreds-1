import com.tim.hundreds.Role
import com.tim.hundreds.User
import com.tim.hundreds.Profile
import com.tim.hundreds.UserRole

import grails.util.Environment

class BootStrap {
  def init = { servletContext ->
    createUserRole()
    createAdminRole()
    createFacilitatorRole()
    createBuyerRole()
  }
  def destroy = {
  }

  def createUserRole(){
    def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

    def user = new User(username: 'cien', password: '12345678')
    def  profile = new Profile(email:'me@techminds.com.mx', firstName:'me', middleName:'middleName', lastName:'lastName').save()
    user.profile = profile
    user.enabled = true
    user.save(flush: true)

    UserRole.create user, userRole, true

    assert User.count() == 1
    assert Role.count() == 1
    assert UserRole.count() == 1
  }

  def createAdminRole(){
    def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
    def user = new User(username: 'admin', password: '12345678')
    def  profile = new Profile(email:'remy.ochoa@techminds.com.mx', firstName:'admin', middleName:'middleName', lastName:'lastName').save()
    user.profile = profile
    user.enabled = true
    user.save(flush: true)

    UserRole.create user, adminRole, true

    assert User.count() == 2
    assert Role.count() == 2
    assert UserRole.count() == 2
  }

  def createFacilitatorRole(){
    def facilitatorRole = new Role(authority: 'ROLE_FACILITATOR').save(flush: true)
    def user = new User(username: 'facilitator', password: '12345678')
    def  profile = new Profile(email:'facilitator@techminds.com.mx', firstName:'facilitator', middleName:'middleName', lastName:'lastName').save()
    user.profile = profile
    user.enabled = true
    user.save(flush: true)

    UserRole.create user, facilitatorRole, true

    assert User.count() == 3
    assert Role.count() == 3
    assert UserRole.count() == 3
  }

  def createBuyerRole(){
    def buyerRole = new Role(authority: 'ROLE_BUYER').save(flush: true)
    assert Role.count() == 4
  }
}
