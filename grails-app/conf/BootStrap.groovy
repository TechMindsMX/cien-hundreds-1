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
      createAllRole()
      createUserWithRole('ROLE_USER',             'cien',           'me@techminds.com.mx')
      createUserWithRole('ROLE_ADMIN',            'admin',          'administrator@trama.mx')
      createUserWithRole('ROLE_FACILITATOR',      'facilitator',    'usuario1@trama.mx')
      createUserWithRole('ROLE_BUYER',            'buyer',          'usuario2trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicicanAdmin', 'QA@trama.mx')
      createUserWithRole('ROLE_COMPANY_ADMIN',    'companyAdmin',   'remy.ochoa@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_VIEWER',  'musicianViewer', 'aleister.r@gmail.com')
      createUserWithRole('ROLE_COMPANY_VIEWER',   'companyViewer',  'demonio.r@gmail.com')
      createGenres()
      createMusicianRoles()
      createBusinessActivity()
    }
  }

  def destroy = {
  }

  def createAllRole(){
    new Role(authority: 'ROLE_USER').save(flush: true)
    new Role(authority: 'ROLE_ADMIN').save(flush: true)
    new Role(authority: 'ROLE_FACILITATOR').save(flush: true)
    new Role(authority: 'ROLE_BUYER').save(flush: true)
    new Role(authority: 'ROLE_MUSICIAN_ADMIN').save(flush: true)
    new Role(authority: 'ROLE_COMPANY_ADMIN').save(flush: true)
    new Role(authority: 'ROLE_MUSICIAN_VIEWER').save(flush: true)
    new Role(authority: 'ROLE_COMPANY_VIEWER').save(flush: true)
    assert Role.count() == 8
  }

  def createUserWithRole(String authority,String name,String email) {
    def userCount = User.count()

    def userRole = Role.findByAuthority(authority)
    def user = new User(username: name, password: '12345678')
    def  profile = new Profile(email: email, firstName: name, middleName:'middleName', lastName:'lastName').save()
    user.profile = profile
    user.enabled = true
    user.save(flush: true)

    UserRole.create user, userRole, true

    assert User.count() == (userCount + 1)
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
