package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

class UserHelperServiceIntegrationSpec extends Specification {

	def userHelperService

    @Unroll
    void """Should get a list of users filtered by role: #role"""() {
    	given: "a user role list"
    		List roleList = role
		when: "we query the service"
			List userList = userHelperService.findListByRole(roleList)
		then: "the list should contain one user"
			userList.size() == result
		where: "we have the next roles"
		role  					    														|| result
		['ROLE_USER']																		|| 1
		['ROLE_ADMIN']			    														|| 1
		['ROLE_FACILITATOR']																|| 1
		['ROLE_BUYER']			    														|| 1
		['ROLE_MUSICIAN_ADMIN']																|| 1
		['ROLE_COMPANY_ADMIN']																|| 1
		['ROLE_MUSICIAN_VIEWER']															|| 1
		['ROLE_COMPANY_VIEWER']																|| 1
		['ROLE_ADMIN','ROLE_MUSICIAN_ADMIN','ROLE_COMPANY_ADMIN']							|| 3

    }
}

