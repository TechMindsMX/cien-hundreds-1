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
    createGenres()
    createMusicianRoles()
    createBusinessActivity()
    createAllRole()
    createUserWithRole('ROLE_ADMIN',            'admin',          'administrator@trama.mx')

    if(Environment.current == Environment.DEVELOPMENT || Environment.current == Environment.TEST) {
      createUserWithRole('ROLE_USER',             'cien',             'usuario1@trama.mx')
      createUserWithRole('ROLE_FACILITATOR',      'facilitator',      'usuario2@trama.mx')
      createUserWithRole('ROLE_BUYER',            'buyer',            'usuario3@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin',    'usuario4@trama.mx')
      createUserWithRole('ROLE_COMPANY_ADMIN',    'companyAdmin',     'usuario5@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_VIEWER',  'musicianViewer',   'usuario6@trama.mx')
      createUserWithRole('ROLE_COMPANY_VIEWER',   'companyViewer',    'usuario7@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin2',   'usuario9@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin3',   'usuario10@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin4',   'usuario11@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin5',   'usuario12@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin6',   'usuario13@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin7',   'usuario14@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin8',   'usuario15@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin9',   'usuario16@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin10',  'usuario17@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin11',  'usuario18@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin12',  'usuario19@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin13',  'usuario20@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin14',  'usuario21@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin15',  'usuario22@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin16',  'usuario23@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin17',  'usuario24@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin18',  'usuario25@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin19',  'usuario26@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin20',  'usuario27@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin21',  'usuario28@trama.mx')
      createUserWithRole('ROLE_MUSICIAN_ADMIN',   'musAdmin22',  'usuario29@trama.mx')
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
    Genre.findOrSaveWhere(name:'Ambiente')
    Genre.findOrSaveWhere(name:'Balada')
    Genre.findOrSaveWhere(name:'Blues')
    Genre.findOrSaveWhere(name:'Jazz')
    Genre.findOrSaveWhere(name:'Latino')
    Genre.findOrSaveWhere(name:'Groove')
    Genre.findOrSaveWhere(name:'Progresivo')
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
