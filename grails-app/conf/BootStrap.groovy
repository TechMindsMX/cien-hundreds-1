import com.tim.hundreds.Role
import com.tim.hundreds.User
import com.tim.hundreds.Profile
import com.tim.hundreds.UserRole

class BootStrap {
  def init = { servletContext ->
    def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

    def user = new User(username: 'josdem', password: '12345678')
    def profile = new Profile(email:'me@techminds.com.mx', firstName:'me', middleName:'middleName', lastName:'lastName')
    user.profile = profile
    user.save(flush: true)

    UserRole.create user, userRole, true

    assert User.count() == 1
    assert Role.count() == 1
    assert UserRole.count() == 1
  }
  def destroy = {
  }
}
