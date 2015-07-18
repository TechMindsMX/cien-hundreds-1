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
        params.max = Math.min(max ?: 10, 100)
        params.offset = params?.offset ?: 0
        def userList = userHelperService.findListByRole(['ROLE_ADMIN','ROLE_COMPANY_ADMIN','ROLE_MUSICIAN_ADMIN'])
        renderView(userList, max, offset)
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

    def renderView(userList, Integer max, Integer offset) {
        render view: 'index', model:[userInstanceList: paginateList(userList, max, offset), userInstanceCount: userList.size()]
    }

    def paginateList(userList, Integer max, Integer offset) {
        max = Math.min(max ?: 10, 100)
        offset = (offset && offset>0) ? params?.offset as int : 0
    
        int total = userList.size()
        int upperLimit = findUpperIndex(params.offset as int, max, total)
        List filteredUsers = userList.getAt(offset..upperLimit)
    
        filteredUsers
    }

  public static int findUpperIndex(int offset, int max, int total) {
    max = offset + max - 1
    if (max >= total) {
      max -= max - total + 1
    }
    return max
  }

}