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
    Role.findOrCreateWhere(authority: 'ROLE_USER')
    Role.findOrCreateWhere(authority: 'ROLE_ADMIN')
    Role.findOrCreateWhere(authority: 'ROLE_FACILITATOR')
    Role.findOrCreateWhere(authority: 'ROLE_BUYER')
    Role.findOrCreateWhere(authority: 'ROLE_MUSICIAN_ADMIN')
    Role.findOrCreateWhere(authority: 'ROLE_COMPANY_ADMIN')
    Role.findOrCreateWhere(authority: 'ROLE_MUSICIAN_VIEWER')
    Role.findOrCreateWhere(authority: 'ROLE_COMPANY_VIEWER')
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
    Genre.findOrCreateWhere(name:'Ambient')
    Genre.findOrCreateWhere(name:'Ballad')
    Genre.findOrCreateWhere(name:'Blues')
    Genre.findOrCreateWhere(name:'Jazz')
    Genre.findOrCreateWhere(name:'Latin')
    Genre.findOrCreateWhere(name:'Groove')
    Genre.findOrCreateWhere(name:'Progressive')
    Genre.findOrCreateWhere(name:'Pop')
    Genre.findOrCreateWhere(name:'Trance')
  }

  def createMusicianRoles(){
    MusicianRole.findOrCreateWhere(name:'Manager')
    MusicianRole.findOrCreateWhere(name:'Element')
    MusicianRole.findOrCreateWhere(name:'Other')
  }

  def createBusinessActivity(){
    BusinessActivity.findOrCreateWhere(name:'Products')
    BusinessActivity.findOrCreateWhere(name:'Services')
  }

}
