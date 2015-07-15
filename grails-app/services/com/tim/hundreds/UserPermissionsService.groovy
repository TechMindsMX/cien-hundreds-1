package com.tim.hundreds

class UserPermissionsService {

  def canAccessByRoles(User currUser, ArrayList currUserAuths) {
    def currUserInstanceAuths = currUser.getAuthorities().authority

log.info "currUserAuths: ${currUserAuths.dump()} -- ${currUserInstanceAuths.dump()} -- ${currUserInstanceAuths.findAll{it in currUserAuths}.isEmpty()}"
    if (currUserInstanceAuths.findAll{it in currUserAuths}.isEmpty()) {
      throw new CheckAccessException ('Not authorized to see this resource')
    }
  }

}