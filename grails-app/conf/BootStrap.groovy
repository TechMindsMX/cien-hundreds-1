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
    createAllRole()
    createUserWithRole('ROLE_USER',             'cien',           'me@techminds.com.mx')
    createUserWithRole('ROLE_ADMIN',            'admin',          'administrator@trama.mx')
    createUserWithRole('ROLE_FACILITATOR',      'facilitator',    'usuario1@trama.mx')
    createUserWithRole('ROLE_BUYER',            'buyer',          'usuario2@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicicanAdmin', 'QA@trama.mx')
    createUserWithRole('ROLE_COMPANY_ADMIN',    'companyAdmin',   'remy.ochoa@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_VIEWER',  'musicianViewer', 'aleister.r@gmail.com')
    createUserWithRole('ROLE_COMPANY_VIEWER',   'companyViewer',  'demonio.r@gmail.com')
    createGenres()
    createMusicianRoles()
    createBusinessActivity()
  }

  def destroy = {
  }

  def createAllRole(){
    new Role.findOrCreateWhere(authority: 'ROLE_USER')
    new Role.findOrCreateWhere(authority: 'ROLE_ADMIN')
    new Role.findOrCreateWhere(authority: 'ROLE_FACILITATOR')
    new Role.findOrCreateWhere(authority: 'ROLE_BUYER')
    new Role.findOrCreateWhere(authority: 'ROLE_MUSICIAN_ADMIN')
    new Role.findOrCreateWhere(authority: 'ROLE_COMPANY_ADMIN')
    new Role.findOrCreateWhere(authority: 'ROLE_MUSICIAN_VIEWER')
    new Role.findOrCreateWhere(authority: 'ROLE_COMPANY_VIEWER')
  }

  def createUserWithRole(String authority, String name, String email) {
    def userRole = Role.findByAuthority(authority)
    def user = new User(username: name, password: 'T3chminds2015')

    if(!user){
      def  profile = new Profile(email: email, firstName: name, middleName:'middleName', lastName:'lastName').save()
      user.profile = profile
      user.enabled = true
      user.save(flush: true)
      UserRole.create user, userRole, true
    }
  }

  def createGenres(){
    new Genre.findOrCreateWhere(name:'Ambient')
    new Genre.findOrCreateWhere(name:'Ballad')
    new Genre.findOrCreateWhere(name:'Blues')
    new Genre.findOrCreateWhere(name:'Jazz')
    new Genre.findOrCreateWhere(name:'Latin')
    new Genre.findOrCreateWhere(name:'Groove')
    new Genre.findOrCreateWhere(name:'Progressive')
    new Genre.findOrCreateWhere(name:'Pop')
    new Genre.findOrCreateWhere(name:'Trance')
  }

  def createMusicianRoles(){
    new MusicianRole.findOrCreateWhere(name:'Manager').save()
    new MusicianRole.findOrCreateWhere(name:'Element').save()
    new MusicianRole.findOrCreateWhere(name:'Other').save()
  }

  def createBusinessActivity(){
    new BusinessActivity.findOrCreateWhere(name:'Products')
    new BusinessActivity.findOrCreateWhere(name:'Services')
  }

}
