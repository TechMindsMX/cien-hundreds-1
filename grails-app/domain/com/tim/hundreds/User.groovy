package com.tim.hundreds

class User {
  String uuid = TokenService.generateToken()
	transient springSecurityService

	String username
	String password
	boolean enabled = false
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

  Profile profile

  static hasMany = [
    musicians : Musician,
    companies : Company
  ]

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
	  password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
}
