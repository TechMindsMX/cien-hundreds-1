package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class UserManagementController {

    def userHelperService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    static showMe = true /*Parametro para aparecer en el menú*/

    @Secured(['ROLE_ADMIN','ROLE_MUSICIAN_ADMIN','ROLE_COMPANY_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        renderView([])
    }

    @Secured(['ROLE_ADMIN'])
    def allAdmins(Integer max, Integer offset) {
        def userList = userHelperService.findListByRole(['ROLE_ADMIN','ROLE_COMPANY_ADMIN','ROLE_MUSICIAN_ADMIN'])
        renderView(userList)
    }

    @Secured(['ROLE_ADMIN'])
    def admins() {
        def userList = userHelperService.findListByRole(['ROLE_ADMIN'])
        renderView(userList)
    }

    @Secured(['ROLE_ADMIN','ROLE_MUSICIAN_ADMIN'])
    def mucicianAdmins() {
        def userList = userHelperService.findListByRole(['ROLE_MUSICIAN_ADMIN'])
        renderView(userList)
    }

    @Secured(['ROLE_ADMIN','ROLE_COMPANY_ADMIN'])
    def companyAdmins() {
        def userList = userHelperService.findListByRole(['ROLE_COMPANY_ADMIN'])
        renderView(userList)
    }

    @Secured(['ROLE_ADMIN','ROLE_MUSICIAN_ADMIN'])
    def musicianViewers() {
        def userList = userHelperService.findListByRole(['ROLE_MUSICIAN_VIEWER'])
        renderView(userList)
    }

    @Secured(['ROLE_ADMIN','ROLE_COMPANY_ADMIN'])
    def companyViewers() {
        def userList = userHelperService.findListByRole(['ROLE_COMPANY_VIEWER'])
        renderView(userList)
    }

    @Secured(['ROLE_ADMIN','ROLE_MUSICIAN_ADMIN'])
    def facilitator() {
        def userList = userHelperService.findListByRole(['ROLE_FACILITATOR'])
        renderView(userList)
    }

    @Secured(['ROLE_ADMIN','ROLE_COMPANY_ADMIN'])
    def buyer() {
    	def userList = userHelperService.findListByRole(['ROLE_BUYER'])
        renderView(userList)
    }

    private renderView(ArrayList userList) {
        render view: 'index', model:[userInstanceList: ControllerPaginationUtil.paginateList(userList, params), userInstanceCount: userList.size()]
    }


}