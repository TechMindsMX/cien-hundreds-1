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
    createUserWithRole('ROLE_USER',             'cien',           'usuario1@trama.mx')
    createUserWithRole('ROLE_ADMIN',            'admin',          'administrator@trama.mx')
    createUserWithRole('ROLE_FACILITATOR',      'facilitator',    'usuario2@trama.mx')
    createUserWithRole('ROLE_BUYER',            'buyer',          'usuario3@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicicanAdmin', 'usuario4@trama.mx')
    createUserWithRole('ROLE_COMPANY_ADMIN',    'companyAdmin',   'usuario5@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_VIEWER',  'musicianViewer', 'usuario6@trama.mx')
    createUserWithRole('ROLE_COMPANY_VIEWER',   'companyViewer',  'usuario7@trama.mx')
    createGenres()
    createMusicianRoles()
    createBusinessActivity()
  }

  def destroy = {
  }

  def createAllRole(){
    Role.findOrSaveWhere(authority: 'ROLE_USER')
    Role.findOrSaveWhere(authority: 'ROLE_ADMIN')
    Role.findOrSaveWhere(authority: 'ROLE_FACILITATOR')
    Role.findOrSaveWhere(authority: 'ROLE_BUYER')
    Role.findOrSaveWhere(authority: 'ROLE_MUSICIAN_ADMIN')
    Role.findOrSaveWhere(authority: 'ROLE_COMPANY_ADMIN')
    Role.findOrSaveWhere(authority: 'ROLE_MUSICIAN_VIEWER')
    Role.findOrSaveWhere(authority: 'ROLE_COMPANY_VIEWER')
  }

  def createUserWithRole(String authority, String name, String email) {
    def userRole = Role.findByAuthority(authority)
    def defaultUser = User.findByUsername(name)

    if(!defaultUser){
      def user = new User(username: name, password: 'T3chminds2015')
      def  profile = new Profile(email: email, firstName: name, motherLastName:'motherLastName', lastName:'lastName').save()
      user.profile = profile
      user.enabled = true
      user.save(flush: true)
      UserRole.create user, userRole, true
    }
  }

  def createGenres(){
    Genre.findOrSaveWhere(name:'Ambient')
    Genre.findOrSaveWhere(name:'Ballad')
    Genre.findOrSaveWhere(name:'Blues')
    Genre.findOrSaveWhere(name:'Jazz')
    Genre.findOrSaveWhere(name:'Latin')
    Genre.findOrSaveWhere(name:'Groove')
    Genre.findOrSaveWhere(name:'Progressive')
    Genre.findOrSaveWhere(name:'Pop')
    Genre.findOrSaveWhere(name:'Trance')
  }

  def createMusicianRoles(){
    MusicianRole.findOrSaveWhere(name:'Manager')
    MusicianRole.findOrSaveWhere(name:'Element')
    MusicianRole.findOrSaveWhere(name:'Other')
  }

  def createBusinessActivity(){
    BusinessActivity.findOrSaveWhere(name:'Products')
    BusinessActivity.findOrSaveWhere(name:'Services')
  }

}
