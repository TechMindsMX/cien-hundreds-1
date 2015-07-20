package com.tim.hundreds

class UserPermissionsService {

	def canEditUserStatus(User currentUser, User userInstance) {
		ArrayList currUserAuths

		def userInstanceAuth = userInstance.getAuthorities().authority
		switch(userInstanceAuth) {
			case '[ROLE_BUYER]':
			currUserAuths = ['ROLE_ADMIN','ROLE_COMPANY_ADMIN']
			break
			case '[ROLE_FACILITATOR]':
			currUserAuths = ['ROLE_ADMIN','ROLE_MUSICIAN_ADMIN']
			break
			default:
			currUserAuths = ['ROLE_ADMIN']
			break
		}

		canAccessByRoles(currentUser, currUserAuths)
	}

	private def canAccessByRoles(User currentUser, ArrayList currUserAuths) {
		def currUserInstanceAuths = currentUser.getAuthorities().authority

		if (currUserInstanceAuths.findAll{it in currUserAuths}.isEmpty()) {
			throw new InvalidPermissionsException ('Not authorized to see this resource')
		}
	}

}