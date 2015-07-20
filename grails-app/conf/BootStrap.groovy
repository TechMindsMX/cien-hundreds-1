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
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin', 'usuario4@trama.mx')
    createUserWithRole('ROLE_COMPANY_ADMIN',    'companyAdmin',   'usuario5@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_VIEWER',  'musicianViewer', 'usuario6@trama.mx')
    createUserWithRole('ROLE_COMPANY_VIEWER',   'companyViewer',  'usuario7@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin9','usuario9@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin10','usuario10@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin11','usuario11@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin12','usuario12@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin13','usuario13@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin14','usuario14@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin15','usuario15@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin16','usuario16@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin17','usuario17@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin18','usuario18@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin19','usuario19@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin20','usuario20@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin21','usuario21@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin22','usuario22@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin23','usuario23@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin24','usuario24@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin25','usuario25@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin26','usuario26@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin27','usuario27@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin28','usuario28@trama.mx')
    createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicianAdmin29','usuario29@trama.mx')
    createGenres()
    createMusicianRoles()
    createBusinessActivity()
    createAllRole()
    createUserWithRole('ROLE_ADMIN',            'admin',          'administrator@trama.mx')

    if(Environment.current == Environment.DEVELOPMENT || Environment.current == Environment.TEST) {
      createUserWithRole('ROLE_USER',             'cien',           'usuario1@trama.mx')
      createUserWithRole('ROLE_FACILITATOR',      'facilitator',    'usuario2@trama.mx')
      createUserWithRole('ROLE_BUYER',            'buyer',          'usuario3@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musicicanAdmin', 'usuario4@trama.mx')
      createUserWithRole('ROLE_COMPANY_ADMIN',    'companyAdmin',   'usuario5@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_VIEWER',  'musicianViewer', 'usuario6@trama.mx')
      createUserWithRole('ROLE_COMPANY_VIEWER',   'companyViewer',  'usuario7@trama.mx')
    }

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
    MusicianRole.findOrSaveWhere(name:'Integrante')
    MusicianRole.findOrSaveWhere(name:'Otro')
  }

  def createBusinessActivity(){
    BusinessActivity.findOrSaveWhere(name:'Productos')
    BusinessActivity.findOrSaveWhere(name:'Servicios')
  }

}
