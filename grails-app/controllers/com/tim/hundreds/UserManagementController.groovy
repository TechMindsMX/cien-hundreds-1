package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class UserManagementController {

	def userHelperService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    static showMe = true /*Parametro para aparecer en el menú*/

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def userList = User.list(params)
        [userInstanceList: userList, userInstanceCount: userList.size()]
    }

    def admins() {
    	def userList = userHelperService.findListByRole('ROLE_ADMIN')
        render view: 'index', model:[userInstanceList: userList, userInstanceCount: userList.size()]

    }
}