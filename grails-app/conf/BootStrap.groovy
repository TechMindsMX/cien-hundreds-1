import com.tim.hundreds.Role
import com.tim.hundreds.User
import com.tim.hundreds.Profile
import com.tim.hundreds.UserRole
import com.tim.hundreds.Genre
import com.tim.hundreds.MusicianRole
import com.tim.hundreds.BusinessActivity

import grails.util.Environment

class BootStrap {
  def init = { servletContext ->
  if(Environment.current == Environment.DEVELOPMENT || Environment.current == Environment.TEST) {
      createUserRole()
      createAdminRole()
      createAllRole()
      createGenres()
      createMusicianRoles()
      createBusinessActivity()
   }
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

  def createAllRole(){
    new Role(authority: 'ROLE_MUSICIAN_ADMIN').save(flush: true)
    new Role(authority: 'ROLE_COMPANY_ADMIN').save(flush: true)
    new Role(authority: 'ROLE_MUSICIAN_VIEWER').save(flush: true)
    new Role(authority: 'ROLE_COMPANY_VIEWER').save(flush: true)
  }

  def createGenres(){
    new Genre(name:'Ambient').save()
    new Genre(name:'Ballad').save()
    new Genre(name:'Blues').save()
    new Genre(name:'Jazz').save()
    new Genre(name:'Latin').save()
    new Genre(name:'Groove').save()
    new Genre(name:'Progressive').save()
    new Genre(name:'Pop').save()
    new Genre(name:'Trance').save()
  }

  def createMusicianRoles(){
    new MusicianRole(name:'Manager').save()
    new MusicianRole(name:'Element').save()
    new MusicianRole(name:'Other').save()
  }

  def createBusinessActivity(){
    new BusinessActivity(name:'Products').save()
    new BusinessActivity(name:'Services').save()
  }

}
